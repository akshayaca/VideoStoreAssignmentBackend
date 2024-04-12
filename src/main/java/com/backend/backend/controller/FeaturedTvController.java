package com.backend.backend.controller;

import com.backend.backend.model.FeaturedTv;
import com.backend.backend.service.FeaturedTvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/fdtv")
public class FeaturedTvController {

    @Autowired
    private FeaturedTvService featuredTvService;

    // Endpoint to get all movies
    @GetMapping("/allftv")
    public ResponseEntity<List<FeaturedTv>> getAllMovies() {
        List<FeaturedTv> tv = featuredTvService.findAllTv();
        if(tv.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tv, HttpStatus.OK);
    }
}