package org.loggingframework.models;

import org.loggingframework.enums.LogLevel;

import java.time.LocalDateTime;

public class LoggerMessage {
    private final LocalDateTime timestamp;
    private final String requestId;
    private final String traceId;
    private final LogLevel level;
    private final String message;

    private LoggerMessage(Builder builder) {
        this.timestamp = LocalDateTime.now();
        this.requestId = builder.requestId;
        this.traceId = builder.traceId;
        this.level = builder.level;
        this.message = builder.message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getTraceId() {
        return traceId;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    public static class Builder {
        private String requestId;
        private String traceId;
        private LogLevel level;
        private String message;

        public Builder setRequestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        public Builder setTraceId(String traceId) {
            this.traceId = traceId;
            return this;
        }

        public Builder setLevel(LogLevel level) {
            this.level = level;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public LoggerMessage build() {
            return new LoggerMessage(this);
        }
    }
}
