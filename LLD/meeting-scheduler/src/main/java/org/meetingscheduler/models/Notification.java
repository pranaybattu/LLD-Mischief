package org.meetingscheduler.models;

// Notification class to represent a notification
public class Notification {
    private int id;
    private String message;
    private User recipient;
    private Meeting meeting;

    public Notification(int id, String message, User recipient, Meeting meeting) {
        this.id = id;
        this.message = message;
        this.recipient = recipient;
        this.meeting = meeting;
    }

    public void send() {
        // Implement logic to send notification
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }
}

