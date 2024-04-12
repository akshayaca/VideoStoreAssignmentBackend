package com.backend.backend.repository;

import com.backend.backend.model.LegalDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface LegalDocumentRepository extends MongoRepository<LegalDocument, String> {
    Optional<LegalDocument> findByTitle(String title);
}