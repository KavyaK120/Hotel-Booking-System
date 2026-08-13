package com.hotelbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.dto.UserResponse;
import com.hotelbooking.entity.User;
import com.hotelbooking.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserService userService;

    // =========================
    // REGISTER
    // =========================
    @PostMapping("/register")
    public UserResponse register(@RequestBody User user) {

        User savedUser = userService.register(user);

        return new UserResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getPhone()
        );
    }

    // =========================
    // LOGIN
    // =========================
    @PostMapping("/login")
    public UserResponse login(@RequestBody User user) {

        User loggedInUser = userService.login(
                user.getEmail(),
                user.getPassword()
        );

        return new UserResponse(
                loggedInUser.getId(),
                loggedInUser.getName(),
                loggedInUser.getEmail(),
                loggedInUser.getPhone()
        );
    }
}