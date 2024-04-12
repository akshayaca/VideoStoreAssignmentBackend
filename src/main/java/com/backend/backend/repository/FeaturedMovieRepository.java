package com.backend.backend.repository;

import com.backend.backend.model.FeaturedMovie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeaturedMovieRepository extends MongoRepository<FeaturedMovie, String> {
    // This already includes a method to fetch all entries: findAll()
}