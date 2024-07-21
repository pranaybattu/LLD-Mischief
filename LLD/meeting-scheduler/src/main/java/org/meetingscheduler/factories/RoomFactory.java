package org.meetingscheduler.factories;

import org.meetingscheduler.models.Room;

// Factory for creating rooms
public class RoomFactory {
    public static Room createRoom(int id, String name, int capacity) {
        return new Room(id, name, capacity);
    }
}
