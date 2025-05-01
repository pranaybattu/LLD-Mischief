package org.RateLimiter.strategy.rateLimiter;

import org.RateLimiter.constant.RateLimiterConstant;
import org.RateLimiter.strategy.IRateLimiter;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SlidingWindowRateLimiter implements IRateLimiter {
    private volatile int windowSize; // in seconds
    private volatile int maxRequests;
    private final Map<String, Request> windowMap = new ConcurrentHashMap<>();

    public SlidingWindowRateLimiter(int windowSize, int maxRequests) {
        this.windowSize = windowSize;
        this.maxRequests = maxRequests;
    }

    @Override
    public boolean canProcess(String key) {
        long time = Instant.now().toEpochMilli();
        windowMap.computeIfAbsent(key, k -> new Request());
        Queue<Long> requests = windowMap.get(key).requestQueue;

        while(!requests.isEmpty() && requests.peek() < time - windowSize * 1000L) {
            requests.poll();
        }

        if(requests.size() < maxRequests) {
            requests.add(time);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void updateConfig(Map<String, Object> config) {
        int windowSize = (int) config.getOrDefault("windowSize", RateLimiterConstant.DEFAULT_WINDOW_SIZE);
        int maxRequests = (int) config.getOrDefault("maxRequests", RateLimiterConstant.DEFAULT_MAX_REQUESTS);
        synchronized (this) {
            this.windowSize = windowSize;
            this.maxRequests = maxRequests;
        }

    }

    private static class Request {
        private final Queue<Long> requestQueue = new ConcurrentLinkedQueue<>();
    }
}
