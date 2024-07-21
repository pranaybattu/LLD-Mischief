package org.meetingscheduler;

import org.meetingscheduler.factories.MeetingFactory;
import org.meetingscheduler.factories.RoomFactory;
import org.meetingscheduler.models.Meeting;
import org.meetingscheduler.models.Room;
import org.meetingscheduler.models.User;
import org.meetingscheduler.services.RoomService;
import org.meetingscheduler.services.UserService;
import org.meetingscheduler.services.MeetingService;
import org.meetingscheduler.services.NotificationService;
import org.meetingscheduler.facade.MeetingSchedulerFacade;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Create services
        RoomService roomService = new RoomService();
        UserService userService = new UserService();
        MeetingService meetingService = new MeetingService();
        NotificationService notificationService = new NotificationService();
        MeetingSchedulerFacade schedulerFacade = new MeetingSchedulerFacade();

        // Create rooms
        Room room1 = RoomFactory.createRoom(1, "Conference Room A", 10);
        Room room2 = RoomFactory.createRoom(2, "Conference Room B", 20);
        roomService.addRoom(room1);
        roomService.addRoom(room2);

        // Create users
        User user1 = new User(1, "Alice", "alice@example.com");
        User user2 = new User(2, "Bob", "bob@example.com");
        userService.addUser(user1);
        userService.addUser(user2);

        // Create a meeting
        Meeting meeting = MeetingFactory.createMeeting(1, "Project Kickoff", new Date(), new Date(), room1);
        meeting.addParticipant(user1);
        meeting.addParticipant(user2);

        // Book the meeting
        schedulerFacade.bookMeeting(meeting);
    }
}
