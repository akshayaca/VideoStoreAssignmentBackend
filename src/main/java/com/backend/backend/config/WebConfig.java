package com.backend.backend.config;

// Inside your main Spring Boot application class or a configuration class

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Adjust the allowedOrigins to match the origin of your React app
        registry.addMapping("/api/**").allowedOrigins("http://localhost:3000");
    }
}
