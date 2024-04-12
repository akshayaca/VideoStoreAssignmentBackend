package com.backend.backend.repository;

import com.backend.backend.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
    // This already includes a method to fetch all entries: findAll()
}