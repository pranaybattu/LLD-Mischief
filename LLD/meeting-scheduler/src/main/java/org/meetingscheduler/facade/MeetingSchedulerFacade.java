package org.meetingscheduler.facade;

import org.meetingscheduler.commands.BookMeetingCommand;
import org.meetingscheduler.commands.CancelMeetingCommand;
import org.meetingscheduler.models.Meeting;

// Facade to provide a simplified interface for booking and managing meetings
public class MeetingSchedulerFacade {
    public void bookMeeting(Meeting meeting) {
        BookMeetingCommand bookMeetingCommand = new BookMeetingCommand(meeting);
        bookMeetingCommand.execute();
    }

    public void cancelMeeting(Meeting meeting) {
        CancelMeetingCommand cancelMeetingCommand = new CancelMeetingCommand(meeting);
        cancelMeetingCommand.execute();
    }
}
