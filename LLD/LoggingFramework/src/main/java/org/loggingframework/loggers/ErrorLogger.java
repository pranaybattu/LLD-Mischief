package org.loggingframework.loggers;

import org.loggingframework.enums.LogLevel;
import org.loggingframework.models.LoggerMessage;
import org.loggingframework.observers.LoggerSubject;

public class ErrorLogger extends AbstractLogger {
    public ErrorLogger() {
        this.level = LogLevel.ERROR;
    }

    @Override
    protected void display(LoggerMessage loggerObj, LoggerSubject loggerSubject) {
        loggerSubject.notifyAllObservers(LogLevel.ERROR, loggerObj);
    }
}
