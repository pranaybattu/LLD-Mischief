package org.meetingscheduler.services;

import org.meetingscheduler.models.Meeting;
import org.meetingscheduler.observers.MeetingObserver;
import org.meetingscheduler.observers.Observer;
import org.meetingscheduler.observers.Subject;

import java.util.ArrayList;
import java.util.List;

// Service for managing meetings
public class MeetingService implements Subject {
    private List<Meeting> meetings;
    private List<Observer> observers;

    public MeetingService() {
        meetings = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting) {
        meetings.add(meeting);
        notifyObservers();
    }

    public void removeMeeting(Meeting meeting) {
        meetings.remove(meeting);
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

