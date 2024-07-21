package org.loggingframework;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        String requestId = "12345";
        String traceId = "abcde";

        logger.info(requestId, traceId, "This is an info message.");
        logger.debug(requestId, traceId, "This is a debug message.");
        logger.error(requestId, traceId, "This is an error message.");
    }
}