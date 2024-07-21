package org.meetingscheduler.services;

import org.meetingscheduler.models.Room;

import java.util.ArrayList;
import java.util.List;

// Service for managing rooms
public class RoomService {
    private List<Room> rooms;

    public RoomService() {
        rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    public Room getRoomById(int id) {
        for (Room room : rooms) {
            if (room.getId() == id) {
                return room;
            }
        }
        return null;
    }
}

