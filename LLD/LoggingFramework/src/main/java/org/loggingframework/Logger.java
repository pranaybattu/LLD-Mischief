package org.loggingframework;

import org.loggingframework.loggers.AbstractLogger;
import org.loggingframework.enums.LogLevel;
import org.loggingframework.models.LoggerMessage;
import org.loggingframework.observers.LoggerSubject;

public class Logger {
    private static final Logger instance = new Logger(); // singleton
    private static AbstractLogger chainOfLogger;
    private static LoggerSubject loggerSubject;

    private Logger() {
        chainOfLogger = LogManager.configureChain();
        loggerSubject = LogManager.addObservers();
    }

    public static Logger getInstance() {
        return instance;
    }

    public void info(String requestId, String traceId, String message) {
        createLog(new LoggerMessage.Builder()
                .setRequestId(requestId)
                .setTraceId(traceId)
                .setLevel(LogLevel.INFO)
                .setMessage(message)
                .build());
    }

    public void error(String requestId, String traceId, String message) {
        createLog(new LoggerMessage.Builder()
                .setRequestId(requestId)
                .setTraceId(traceId)
                .setLevel(LogLevel.ERROR)
                .setMessage(message)
                .build());
    }

    public void debug(String requestId, String traceId, String message) {
        createLog(new LoggerMessage.Builder()
                .setRequestId(requestId)
                .setTraceId(traceId)
                .setLevel(LogLevel.DEBUG)
                .setMessage(message)
                .build());
    }

    private void createLog(LoggerMessage message) {
        chainOfLogger.logMessage(message, loggerSubject);
    }
}