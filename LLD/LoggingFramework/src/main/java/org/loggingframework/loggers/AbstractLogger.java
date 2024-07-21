package org.loggingframework.loggers;

import org.loggingframework.enums.LogLevel;
import org.loggingframework.models.LoggerMessage;
import org.loggingframework.observers.LoggerSubject;

public abstract class AbstractLogger {
    protected LogLevel level;
    private AbstractLogger nextLevelLogger;

    public void setNextLevelLogger(AbstractLogger nextLevelLogger) {
        this.nextLevelLogger = nextLevelLogger;
    }

    public void logMessage(LoggerMessage loggerObj, LoggerSubject loggerSubject) {
        if (this.level == loggerObj.getLevel()) {
            display(loggerObj, loggerSubject);
        }

        if (nextLevelLogger != null) {
            nextLevelLogger.logMessage(loggerObj, loggerSubject);
        }
    }

    protected abstract void display(LoggerMessage message, LoggerSubject loggerSubject);
}
