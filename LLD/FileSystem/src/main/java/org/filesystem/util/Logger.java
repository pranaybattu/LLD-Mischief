package org.filesystem.util;

import java.time.LocalDateTime;

/**
 * Simple logger utility for the file system.
 */
public class Logger {
    /**
     * Logs an operation with details.
     *
     * @param operation Operation name.
     * @param details   Additional details.
     */
    public static void log(String operation, String details) {
        System.out.println(LocalDateTime.now() + " - " + operation + " - " + details);
    }
}

