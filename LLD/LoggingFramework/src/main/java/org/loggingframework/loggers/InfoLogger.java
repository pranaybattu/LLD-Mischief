package org.loggingframework.loggers;

import org.loggingframework.enums.LogLevel;
import org.loggingframework.models.LoggerMessage;
import org.loggingframework.observers.LoggerSubject;

public class InfoLogger extends AbstractLogger {
    public InfoLogger() {
        this.level = LogLevel.INFO;
    }

    @Override
    protected void display(LoggerMessage loggerObj, LoggerSubject loggerSubject) {
        loggerSubject.notifyAllObservers(LogLevel.INFO, loggerObj);
    }
}
