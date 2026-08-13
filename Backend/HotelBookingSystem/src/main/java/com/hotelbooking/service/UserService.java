package com.hotelbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.entity.User;
import com.hotelbooking.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // =========================
    // REGISTER
    // =========================
    public User register(User user) {

        // Check if email already exists
        User existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser != null) {
            throw new RuntimeException("Email already registered");
        }

        return userRepository.save(user);
    }

    // =========================
    // LOGIN
    // =========================
    public User login(String email, String password) {

        User user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        throw new RuntimeException("Invalid email or password");
    }
}