package com.backend.backend.controller;

import com.backend.backend.model.LegalDocument;
import com.backend.backend.service.LegalDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/legal")
public class LegalDocumentController {
    @Autowired
    private LegalDocumentService service;

    @GetMapping("/{title}")
    public ResponseEntity<LegalDocument> getLegalDocument(@PathVariable String title) {
        return service.getDocumentByTitle(title)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}