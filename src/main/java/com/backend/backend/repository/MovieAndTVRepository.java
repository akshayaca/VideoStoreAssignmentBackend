package com.backend.backend.repository;

import com.backend.backend.model.MovieAndTV;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieAndTVRepository extends MongoRepository<MovieAndTV, String>
{
    @Query("{'title': {$regex: ?0, $options: 'i'}}")
    List<MovieAndTV> findByTitleContaining(String title);
    List<MovieAndTV> findByType(String type);

}
