package org.meetingscheduler.strategies;

import org.meetingscheduler.models.User;

import java.util.Date;

// Strategy interface for checking availability
public interface AvailabilityStrategy {
    boolean isAvailable(User user, Date startTime, Date endTime);
}
