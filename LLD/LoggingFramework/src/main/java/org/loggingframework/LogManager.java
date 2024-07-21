package org.loggingframework;

import org.loggingframework.enums.LogLevel;
import org.loggingframework.loggers.*;
import org.loggingframework.observers.ConsoleLogger;
import org.loggingframework.observers.FileLogger;
import org.loggingframework.observers.LoggerSubject;

public class LogManager {
    public static AbstractLogger configureChain() {
        AbstractLogger infoLogger = new InfoLogger();
        AbstractLogger errorLogger = new ErrorLogger();
        AbstractLogger debugLogger = new DebugLogger();

        infoLogger.setNextLevelLogger(errorLogger);
        errorLogger.setNextLevelLogger(debugLogger);

        return infoLogger;
    }

    public static LoggerSubject addObservers() {
        LoggerSubject loggerSubject = new LoggerSubject();
        ConsoleLogger consoleLogger = new ConsoleLogger();
        FileLogger fileLogger = new FileLogger();

        loggerSubject.addObserver(LogLevel.INFO, consoleLogger);
        loggerSubject.addObserver(LogLevel.ERROR, consoleLogger);
        loggerSubject.addObserver(LogLevel.DEBUG, consoleLogger);

        loggerSubject.addObserver(LogLevel.ERROR, fileLogger);

        return loggerSubject;
    }
}
