package org.meetingscheduler.commands;

import org.meetingscheduler.models.Meeting;
import org.meetingscheduler.services.MeetingService;

// Command to book a meeting
public class BookMeetingCommand implements Command {
    private MeetingService meetingService;
    private Meeting meeting;

    public BookMeetingCommand(MeetingService meetingService, Meeting meeting) {
        this.meetingService = meetingService;
        this.meeting = meeting;
    }

    @Override
    public void execute() {
        meetingService.addMeeting(meeting);
        System.out.println("Meeting booked: " + meeting.getTitle());
    }
}
