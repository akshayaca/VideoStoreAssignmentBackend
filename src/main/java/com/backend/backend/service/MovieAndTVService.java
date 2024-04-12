package com.backend.backend.service;

import com.backend.backend.model.MovieAndTV;
import com.backend.backend.repository.MovieAndTVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieAndTVService {
    @Autowired
    private MovieAndTVRepository movieAndTVRepository;

    public List<MovieAndTV> findAll() {
        return movieAndTVRepository.findAll();
    }
    public MovieAndTV saveMovieAndTV(MovieAndTV movieAndTV) {
        return movieAndTVRepository.save(movieAndTV);
    }

    public MovieAndTVService(MovieAndTVRepository movieAndTVRepository) {
        this.movieAndTVRepository = movieAndTVRepository;
    }
    public List<MovieAndTV> findMoviesByTitle(String title) {
        return movieAndTVRepository.findByTitleContaining(title);
    }

    public Optional<MovieAndTV> findByIdAndType(String id, String type) {
        Optional<MovieAndTV> movieAndTvOptional = movieAndTVRepository.findById(id);
        return movieAndTvOptional
                .filter(movieAndTv -> movieAndTv.getType().equalsIgnoreCase(type));
    }
    public Optional<MovieAndTV> findById(String id) {
        return movieAndTVRepository.findById(id);
    }

    public List<MovieAndTV> findByType(String type) {
        return movieAndTVRepository.findByType(type);
    }
    public Optional<Optional<MovieAndTV>> updateMovieAndTV(String id, MovieAndTV updateInfo) {
        return movieAndTVRepository.findById(id).map(existingMovie -> {
            if(updateInfo.getTitle() != null) existingMovie.setTitle(updateInfo.getTitle());
            if(updateInfo.getSynopsis() != null) existingMovie.setSynopsis(updateInfo.getSynopsis());
            if(updateInfo.getSmallPoster() != null) existingMovie.setSmallPoster(updateInfo.getSmallPoster());
            if(updateInfo.getLargePoster() != null) existingMovie.setLargePoster(updateInfo.getLargePoster());
            if(updateInfo.getRentPrice() != null) existingMovie.setRentPrice(updateInfo.getRentPrice());
            if(updateInfo.getPurchasePrice() != null) existingMovie.setPurchasePrice(updateInfo.getPurchasePrice());
            return Optional.of(movieAndTVRepository.save(existingMovie));
        });
    }
    public boolean deleteMovieAndTV(String id) {
        return movieAndTVRepository.findById(id).map(movie -> {
            movieAndTVRepository.delete(movie);
            return true;
        }).orElse(false);
    }
}

