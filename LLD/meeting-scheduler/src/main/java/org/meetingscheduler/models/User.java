package org.meetingscheduler.models;

import java.util.ArrayList;
import java.util.List;

// User class to represent a user
public class User {
    private int id;
    private String name;
    private String email;
    private List<Meeting> calendar;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.calendar = new ArrayList<>();
    }

    public void acceptInvite(Meeting meeting) {
        calendar.add(meeting);
    }

    public void rejectInvite(Meeting meeting) {
        calendar.remove(meeting);
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Meeting> getCalendar() {
        return calendar;
    }

    public void setCalendar(List<Meeting> calendar) {
        this.calendar = calendar;
    }
}

