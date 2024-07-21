package org.meetingscheduler.services;

import org.meetingscheduler.models.Notification;
import org.meetingscheduler.observers.NotificationObserver;
import org.meetingscheduler.observers.Observer;
import org.meetingscheduler.observers.Subject;

import java.util.ArrayList;
import java.util.List;

// Service for managing notifications
public class NotificationService implements Subject {
    private List<Notification> notifications;
    private List<Observer> observers;

    public NotificationService() {
        notifications = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void addNotification(Notification notification) {
        notifications.add(notification);
        notifyObservers();
    }

    public void removeNotification(Notification notification) {
        notifications.remove(notification);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}