package org.loggingframework.observers;

import org.loggingframework.models.LoggerMessage;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements LogObserver {
    @Override
    public void log(LoggerMessage message) {
        try (FileWriter fileWriter = new FileWriter("log.txt", true)) {
            fileWriter.write("FILE MESSAGE: [" + message.getTimestamp() + "] " +
                    "[" + message.getRequestId() + "] " +
                    "[" + message.getTraceId() + "] " +
                    "[" + message.getLevel() + "] " +
                    message.getMessage() + "\n");
        } catch (IOException e) {
            System.err.println("Failed to write to file: " + e.getMessage());
        }
    }
}

