package org.RateLimiter.strategy.rateLimiter;

import org.RateLimiter.strategy.IRateLimiter;

import java.util.Map;

public class TokenBucketRateLimiter implements IRateLimiter {

    public TokenBucketRateLimiter() {}

    @Override
    public boolean canProcess(String key) {
        return true;
    }

    @Override
    public void updateConfig(Map<String, Object> config) {

    }
}
