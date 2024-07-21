package org.loggingframework.loggers;

import org.loggingframework.enums.LogLevel;
import org.loggingframework.models.LoggerMessage;
import org.loggingframework.observers.LoggerSubject;

public class DebugLogger extends AbstractLogger {
    public DebugLogger() {
        this.level = LogLevel.DEBUG;
    }

    @Override
    protected void display(LoggerMessage loggerObj, LoggerSubject loggerSubject) {
        loggerSubject.notifyAllObservers(LogLevel.DEBUG, loggerObj);
    }
}