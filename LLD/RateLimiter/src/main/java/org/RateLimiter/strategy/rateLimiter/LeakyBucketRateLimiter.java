package org.RateLimiter.strategy.rateLimiter;

import org.RateLimiter.strategy.IRateLimiter;

import java.util.Map;

public class LeakyBucketRateLimiter implements IRateLimiter {

    public LeakyBucketRateLimiter() {}

    @Override
    public boolean canProcess(String key) {
        return false;
    }

    @Override
    public void updateConfig(Map<String, Object> config) {

    }
}
