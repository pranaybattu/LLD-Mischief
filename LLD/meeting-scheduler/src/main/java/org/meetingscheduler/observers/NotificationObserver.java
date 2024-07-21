package org.meetingscheduler.observers;

import org.meetingscheduler.models.Notification;

public class NotificationObserver implements Observer {
    private Notification notification;

    public NotificationObserver(Notification notification) {
        this.notification = notification;
    }

    @Override
    public void update() {
        // Implement logic to send notification
    }
}
