package org.loggingframework.observers;

import org.loggingframework.models.LoggerMessage;

public interface LogObserver {
    void log(LoggerMessage message); // push type observer pattern
}
