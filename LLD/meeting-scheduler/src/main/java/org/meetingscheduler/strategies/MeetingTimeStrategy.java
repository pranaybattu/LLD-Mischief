package org.meetingscheduler.strategies;

import org.meetingscheduler.models.User;

import java.util.Date;
import java.util.List;

public interface MeetingTimeStrategy {
    Date findBestTime(List<User> participants);
}
