package org.RateLimiter.strategy;

import java.util.Map;

public interface IRateLimiter {
    boolean canProcess(String key);
    void updateConfig(Map<String, Object> config);
}
