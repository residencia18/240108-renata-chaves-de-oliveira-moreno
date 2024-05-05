package com.renatachom.springsecurity.repository;

import org.springframework.stereotype.Service;

import com.renatachom.springsecurity.entities.UserActivity;

import java.time.Instant;
import java.util.UUID;

@Service
public class UserActivityService {

    private final UserActivityRepository userActivityRepository;

    public UserActivityService(UserActivityRepository userActivityRepository) {
        this.userActivityRepository = userActivityRepository;
    }

    public void logUserActivity(UUID userId, String action) {
        UserActivity userActivity = new UserActivity();
        userActivity.setUserId(userId);
        userActivity.setAction(action);
        userActivity.setTimestamp(Instant.now());
        userActivityRepository.save(userActivity);
    }
}
