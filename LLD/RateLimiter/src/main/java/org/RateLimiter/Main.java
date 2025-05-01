package org.RateLimiter;

import org.RateLimiter.constant.RateLimiterConstant;
import org.RateLimiter.controller.RateLimiterController;
import org.RateLimiter.enums.RateLimiterType;
import org.RateLimiter.utility.ThreadUtility;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("------------Starting API Rate Limiter--------");

        RateLimiterType rateLimiterType = RateLimiterType.SLIDING_WINDOW;
        Map<String, Object> config = new HashMap<>();
        config.put("windowSize", 3);
        config.put("maxRequests", 3);

        RateLimiterController userRateLimiterController = new RateLimiterController(rateLimiterType, config);


        System.out.println("------------Starting API Rate Limiter for Users--------");
        String[] users = {"userA", "userB", "userC"};
        Random random = new Random();
        for(int i = 0; i < users.length; ++i) {
            userRateLimiterController.processRequest(users[i], random.nextInt(7) + 1);
            ThreadUtility.sleep(4000);
            userRateLimiterController.processRequest(users[i], random.nextInt(7) + 1);
            System.out.println("--------------------");
        }

        System.out.println("------------Starting API Rate Limiter for IPs--------");
        RateLimiterController ipRateLimiterController = new RateLimiterController(rateLimiterType, config);

        String[] ips = {"IP1", "IP2", "IP3"};
        for(int i = 0; i < ips.length; ++i) {
            ipRateLimiterController.processRequest(ips[i], random.nextInt(7) + 1);
            ThreadUtility.sleep(4000);
            ipRateLimiterController.processRequest(ips[i], random.nextInt(7) + 1);
            System.out.println("--------------------");
        }

        // similarly we can do for endpoints
            // String[] endpoints = {"endpoint1", "endpoint2", "endpoint3"};


        System.out.println("------------Starting API Rate Limiter for IPs--------");
        RateLimiterController globalRateLimiterController = new RateLimiterController(rateLimiterType, config);
        for(int i = 0; i < 3; ++i) {
            globalRateLimiterController.processRequest(RateLimiterConstant.GLOBAL_LIMITER_KEY, random.nextInt(7) + 1);
            ThreadUtility.sleep(4000);
            globalRateLimiterController.processRequest(RateLimiterConstant.GLOBAL_LIMITER_KEY, random.nextInt(7) + 1);
            System.out.println("--------------------");
        }
    }

}