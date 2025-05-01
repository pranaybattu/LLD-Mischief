package org.RateLimiter.factory;

import org.RateLimiter.constant.RateLimiterConstant;
import org.RateLimiter.enums.RateLimiterType;
import org.RateLimiter.strategy.IRateLimiter;
import org.RateLimiter.strategy.rateLimiter.LeakyBucketRateLimiter;
import org.RateLimiter.strategy.rateLimiter.SlidingWindowRateLimiter;
import org.RateLimiter.strategy.rateLimiter.TokenBucketRateLimiter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

    public class RateLimiterFactory {
    private static final Map<RateLimiterType, Function<Map<String, Object>, IRateLimiter>> rateLimiterMap = new HashMap<>();

    // SINGLETON - EAGER INTIALIZATION
    private static final RateLimiterFactory instance = new RateLimiterFactory();

    static {
        // TOKEN BUCKET
        rateLimiterMap.put(RateLimiterType.TOKEN_BUCKET, config -> {
            return new TokenBucketRateLimiter();
        });

        // SLIDING WINDOW
        rateLimiterMap.put(RateLimiterType.SLIDING_WINDOW, config -> {
            int windowSize = (int) config.getOrDefault("windowSize", RateLimiterConstant.DEFAULT_WINDOW_SIZE);
            int maxRequests = (int) config.getOrDefault("maxRequests", RateLimiterConstant.DEFAULT_MAX_REQUESTS);

            return new SlidingWindowRateLimiter(windowSize, maxRequests);
        });

        // LEAKY BUCKET
        rateLimiterMap.put(RateLimiterType.LEAKY_BUCKET, config -> {
            return new LeakyBucketRateLimiter();
        });
    }

    private RateLimiterFactory() {}

    public static RateLimiterFactory getInstance() {
        return instance;
    }

    public static IRateLimiter createRateLimiter(RateLimiterType rateLimiterType, Map<String, Object> config) {
        Function<Map<String, Object>, IRateLimiter> rateLimiterFunction = rateLimiterMap.get(rateLimiterType);

        if(rateLimiterFunction == null) {
            throw new IllegalArgumentException("Invalid Rate Limiter Type");
        }

        return rateLimiterFunction.apply(config);
    }
}
