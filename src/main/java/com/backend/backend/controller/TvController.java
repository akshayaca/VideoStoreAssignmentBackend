package com.backend.backend.controller;

import com.backend.backend.model.Tv;
import com.backend.backend.service.TvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tv")
public class TvController {

    @Autowired
    private TvService tvService;

    // Endpoint to get all movies
    @GetMapping("/alltv")
    public ResponseEntity<List<Tv>> getAllTv() {
        List<Tv> tv = tvService.findAllTv();
        if(tv.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tv, HttpStatus.OK);
    }
}