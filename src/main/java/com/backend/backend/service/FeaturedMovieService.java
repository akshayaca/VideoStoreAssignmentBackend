package com.backend.backend.service;

import com.backend.backend.model.FeaturedMovie;
import com.backend.backend.model.Movie;
import com.backend.backend.repository.FeaturedMovieRepository;
import com.backend.backend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeaturedMovieService {

    @Autowired
    private FeaturedMovieRepository featuredmovieRepository;

    public List<FeaturedMovie> findAllMovies() {
        return featuredmovieRepository.findAll();
    }
}