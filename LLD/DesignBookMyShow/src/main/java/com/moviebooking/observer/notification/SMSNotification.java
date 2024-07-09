package com.moviebooking.observer.notification;

public class SMSNotification implements NotificationObserver {
    @Override
    public void update(String message) {
        System.out.println("Sending SMS notification: " + message);
    }
}
