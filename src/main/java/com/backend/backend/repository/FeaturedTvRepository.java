package com.backend.backend.repository;

import com.backend.backend.model.FeaturedMovie;
import com.backend.backend.model.FeaturedTv;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeaturedTvRepository extends MongoRepository<FeaturedTv, String> {
    // This already includes a method to fetch all entries: findAll()
}