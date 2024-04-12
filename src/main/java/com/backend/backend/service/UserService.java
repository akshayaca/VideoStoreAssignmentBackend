package com.backend.backend.service;

import com.backend.backend.model.MovieAndTV;
import com.backend.backend.model.User;
import com.backend.backend.repository.UserRepository;
import com.backend.backend.utility.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean isEmailRegistered(String email) {
        return userRepository.existsByEmail(email);
    }

    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    public User registerUser(User newUser) {
        // Check if the email is already registered
        if (isEmailRegistered(newUser.getEmail())) {
            // Email is already registered, handle as needed
            return null; // For example, you can return null or throw an exception
        }

        // Email is not registered, proceed with user registration
        // Assuming newUser comes with plain text password
        String hashedPassword = PasswordUtil.hashPassword(newUser.getPassword());
        newUser.setPassword(hashedPassword);
        return userRepository.save(newUser); // Save the user with hashed password
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean login(String email, String password) {
        Optional<User> userOptional = findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return PasswordUtil.checkPassword(password, user.getPassword());
        }
        return false;
    }
}