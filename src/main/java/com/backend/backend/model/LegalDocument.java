package com.backend.backend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "legalDocuments")
public class LegalDocument {
    // Getters and setters
    @Id
    private String id;
    private String title;
    private String content;

    // Constructors
    public LegalDocument() {
    }

    public LegalDocument(String title, String content) {
        this.title = title;
        this.content = content;
    }

}