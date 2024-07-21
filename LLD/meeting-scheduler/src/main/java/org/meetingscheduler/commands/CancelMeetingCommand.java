package org.meetingscheduler.commands;

import org.meetingscheduler.models.Meeting;

public class CancelMeetingCommand implements Command {
    private Meeting meeting;

    public CancelMeetingCommand(Meeting meeting) {
        this.meeting = meeting;
    }

    @Override
    public void execute() {
        // Implement logic to cancel a meeting
    }
}
