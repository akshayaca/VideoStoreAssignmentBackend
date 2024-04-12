package com.backend.backend.repository;

import com.backend.backend.model.Tv;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TvRepository extends MongoRepository<Tv, String> {
    // This already includes a method to fetch all entries: findAll()
}