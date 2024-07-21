package org.loggingframework.observers;

import org.loggingframework.enums.LogLevel;
import org.loggingframework.models.LoggerMessage;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LoggerSubject {
    private final Map<LogLevel, List<LogObserver>> logObservers = new EnumMap<>(LogLevel.class);

    public void addObserver(LogLevel level, LogObserver logObserver) {
        List<LogObserver> observers = logObservers.computeIfAbsent(level, k -> new ArrayList<>());
        observers.add(logObserver);
    }

    public void removeObserver(LogObserver logObserver) {
        logObservers.values().forEach(observers -> observers.remove(logObserver));
    }

    public void notifyAllObservers(LogLevel level, LoggerMessage message) {
        List<LogObserver> observers = logObservers.get(level);
        if (observers != null) {
            observers.forEach(observer -> observer.log(message));
        }
    }
}
