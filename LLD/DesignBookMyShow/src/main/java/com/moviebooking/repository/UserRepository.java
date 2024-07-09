package com.moviebooking.repository;

import com.moviebooking.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepository {
    private Map<String, User> userStore = new HashMap<>();

    public Optional<User> findById(String userId) {
        return Optional.ofNullable(userStore.get(userId));
    }

    public Optional<User> findByEmailAndPassword(String email, String password) {
        return userStore.values().stream()
                .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
                .findFirst();
    }

    public void save(User user) {
        userStore.put(user.getUserId(), user);
        System.out.println("User saved: " + user.getName());
    }

    public void delete(String userId) {
        userStore.remove(userId);
        System.out.println("User deleted: " + userId);
    }
}