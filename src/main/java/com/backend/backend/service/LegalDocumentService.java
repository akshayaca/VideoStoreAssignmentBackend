package com.backend.backend.service;

import com.backend.backend.model.LegalDocument;
import com.backend.backend.repository.LegalDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LegalDocumentService {
    @Autowired
    private LegalDocumentRepository repository;

    public Optional<LegalDocument> getDocumentByTitle(String title) {
        return repository.findByTitle(title);
    }
}