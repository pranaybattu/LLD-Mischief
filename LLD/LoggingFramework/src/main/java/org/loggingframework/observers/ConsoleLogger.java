package org.loggingframework.observers;

import org.loggingframework.models.LoggerMessage;

public class ConsoleLogger implements LogObserver {
    @Override
    public void log(LoggerMessage message) {
        System.out.println("CONSOLE MESSAGE: [" + message.getTimestamp() + "] " +
                "[" + message.getRequestId() + "] " +
                "[" + message.getTraceId() + "] " +
                "[" + message.getLevel() + "] " +
                message.getMessage());
    }
}
