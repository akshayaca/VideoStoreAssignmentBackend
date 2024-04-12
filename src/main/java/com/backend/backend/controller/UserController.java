package com.backend.backend.controller;

import com.backend.backend.dto.UserLoginDto;
import com.backend.backend.model.User;
import com.backend.backend.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        Optional<User> user = userService.findById(id);
        if(user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDto loginDto) {
        boolean loginSuccess = userService.login(loginDto.getEmail(), loginDto.getPassword());
        if (loginSuccess) {
            String token = Jwts.builder()
                    .setSubject(loginDto.getEmail())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // Token valid for 1 day
                    .signWith(SignatureAlgorithm.HS512, "secretkey") // Use a secure key
                    .compact();

            return ResponseEntity.ok().body("{\"accessToken\": \"" + token + "\"}");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody User newUser) {
        // Check if the email is already registered
        if (userService.isEmailRegistered(newUser.getEmail())) {
            return ResponseEntity.badRequest().body("Email is already registered");
        }

        // Proceed with user registration
        User registeredUser = userService.registerUser(newUser);
        if (registeredUser != null && registeredUser.getId() != null) {
            return ResponseEntity.ok("User registered successfully");
        } else {
            return ResponseEntity.internalServerError().body("User registration failed");
        }
    }
}
