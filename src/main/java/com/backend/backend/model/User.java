package com.backend.backend.model;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "AllUsers")
public class User {

    // Standard getters and setters
    @Getter
    @Id
    private String id;
    @Getter
    private String name;
    @Getter
    private String email;
    // Getters and Setters for firstName and lastName
    @Getter
    private String firstName;
    private String lastName;

    private String password;


    // Constructors, hashCode, equals, and toString methods are omitted for brevity
}