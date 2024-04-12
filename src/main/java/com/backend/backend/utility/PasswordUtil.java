package com.backend.backend.utility;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // Hash a plain-text password
    public static String hashPassword(String plainTextPassword){
        return encoder.encode(plainTextPassword);
    }

    // Check a plain-text password against a hashed one
    public static boolean checkPassword(String plainTextPassword, String hashedPassword) {
        return encoder.matches(plainTextPassword, hashedPassword);
    }
}