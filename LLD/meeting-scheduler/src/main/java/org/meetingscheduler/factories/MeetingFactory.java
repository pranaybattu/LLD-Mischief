package org.meetingscheduler.factories;

import org.meetingscheduler.models.Meeting;
import org.meetingscheduler.models.Room;

import java.util.Date;

public class MeetingFactory {
    public static Meeting createMeeting(int id, String title, Date startTime, Date endTime, Room room) {
        return new Meeting(id, title, startTime, endTime, room);
    }
}
