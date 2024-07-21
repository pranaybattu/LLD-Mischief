package org.meetingscheduler.observers;

import org.meetingscheduler.models.Meeting;

// Observer for meeting updates
public class MeetingObserver implements Observer {
    private Meeting meeting;

    public MeetingObserver(Meeting meeting) {
        this.meeting = meeting;
    }

    @Override
    public void update() {
        // Implement logic to update meeting
    }
}
