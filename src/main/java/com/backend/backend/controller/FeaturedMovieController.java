package com.backend.backend.controller;

import com.backend.backend.model.FeaturedMovie;
import com.backend.backend.service.FeaturedMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
    @RequestMapping("/api/fdmovies")
public class FeaturedMovieController {

    @Autowired
    private FeaturedMovieService featuredMovieService;

    // Endpoint to get all movies
    @GetMapping("/allfdmovies")
    public ResponseEntity<List<FeaturedMovie>> getAllMovies() {
        List<FeaturedMovie> movies = featuredMovieService.findAllMovies();
        if(movies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
}