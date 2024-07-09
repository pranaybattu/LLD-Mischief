package com.moviebooking.observer.notification;

public class EmailNotification implements NotificationObserver {
    @Override
    public void update(String message) {
        System.out.println("Sending email notification: " + message);
    }
}
