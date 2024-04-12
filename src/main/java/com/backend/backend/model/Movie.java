package com.backend.backend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "AllMovies")
public class Movie {
    // Getters and setters
    @Id
    private String id;
    private String title;
    private String description;
    private String poster;

    // Default constructor is needed by MongoDB to instantiate objects when fetching data
    public Movie() {
    }

    // Constructor with parameters for easy creation of objects
    public Movie(String title, String description, String poster) {
        this.title = title;
        this.description = description;
        this.poster = poster;
    }

}
