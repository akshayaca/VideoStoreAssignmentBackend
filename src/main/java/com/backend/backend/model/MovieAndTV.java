package com.backend.backend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "MovieAndTv")
public class MovieAndTV {
    // Setters
    // Getters
    @Id
    private String id;
    private String type;
    private String title;
    private String synopsis;
    private String smallPoster;
    private String largePoster;
    private Double rentPrice;
    private Double purchasePrice;

    // Default constructor
    public MovieAndTV() {
    }

    // Constructor with all fields
    public MovieAndTV(String id, String type, String title, String synopsis, String smallPoster, String largePoster, double rentPrice, double purchasePrice) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.synopsis = synopsis;
        this.smallPoster = smallPoster;
        this.largePoster = largePoster;
        this.rentPrice = rentPrice;
        this.purchasePrice = purchasePrice;
    }

}
