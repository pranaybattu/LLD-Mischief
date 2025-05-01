package org.RateLimiter.utility;

public final class ThreadUtility {
    private ThreadUtility() {}

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
