package com.moviebooking.service;


import com.moviebooking.observer.notification.NotificationObserver;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private List<NotificationObserver> observers = new ArrayList<>();

    public void addObserver(NotificationObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(NotificationObserver observer) {
        observers.remove(observer);
    }

    public void notifyAllObservers(String message) {
        for (NotificationObserver observer : observers) {
            observer.update(message);
        }
        System.out.println("Notifications sent: " + message);
    }
}
