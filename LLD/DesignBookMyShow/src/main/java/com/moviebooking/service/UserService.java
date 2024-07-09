package com.moviebooking.service;

import com.moviebooking.model.User;
import com.moviebooking.repository.UserRepository;

public class UserService {

    private UserRepository userRepository = new UserRepository();

    public void registerUser(User user) {
        userRepository.save(user);
        System.out.println("User registered: " + user.getName());
    }

    public User loginUser(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password).orElse(null);
        if (user != null) {
            System.out.println("User logged in: " + user.getName());
        } else {
            System.out.println("Invalid login credentials");
        }
        return user;
    }

    public void logoutUser(String userId) {
        // In a real application, you might invalidate the user session here
        System.out.println("User logged out: " + userId);
    }

    public User getUserById(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    // Other user-related methods
}
