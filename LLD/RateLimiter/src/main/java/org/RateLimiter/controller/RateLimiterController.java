package org.RateLimiter.controller;

import org.RateLimiter.enums.RateLimiterType;
import org.RateLimiter.factory.RateLimiterFactory;
import org.RateLimiter.strategy.IRateLimiter;

import java.util.Map;

public class RateLimiterController {
    private static final RateLimiterFactory rateLimiterFactory = RateLimiterFactory.getInstance();
    private IRateLimiter rateLimiter;

    public RateLimiterController(RateLimiterType rateLimiterType, Map<String, Object> config) {
        this.rateLimiter = rateLimiterFactory.createRateLimiter(rateLimiterType, config);
    }

    public void updateRateLimiter(RateLimiterType rateLimiterType, Map<String, Object> config) {
        this.rateLimiter = rateLimiterFactory.createRateLimiter(rateLimiterType, config);
    }

    public void processRequest(String key) {
        boolean canProcess = rateLimiter.canProcess(key);
        if(canProcess) {
            System.out.println("😁 Allowed request for key: " + key);
        } else {
            System.out.println("😢 Rejected request for key: " + key);
        }
    }

    public void processRequest(String key, int count) {
        for(int i = 0; i < count; i++) {
            processRequest(key);
        }
    }

}
