package com.moviebooking.controller;

import com.moviebooking.model.User;
import com.moviebooking.service.UserService;

public class UserController {

    private UserService userService = new UserService();

    public void registerUser(User user) {
        userService.registerUser(user);
        System.out.println("User registered: " + user.getName());
    }

    public void loginUser(String email, String password) {
        User user = userService.loginUser(email, password);
        if (user != null) {
            System.out.println("User logged in: " + user.getName());
        } else {
            System.out.println("Invalid login credentials");
        }
    }

    public void logoutUser(String userId) {
        userService.logoutUser(userId);
        System.out.println("User logged out: " + userId);
    }

    // Other user methods
}
