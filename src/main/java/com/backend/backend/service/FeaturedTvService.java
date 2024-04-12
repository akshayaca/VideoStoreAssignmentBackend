package com.backend.backend.service;

import com.backend.backend.model.FeaturedMovie;
import com.backend.backend.model.FeaturedTv;
import com.backend.backend.repository.FeaturedMovieRepository;
import com.backend.backend.repository.FeaturedTvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeaturedTvService {

    @Autowired
    private FeaturedTvRepository featuredTvRepository;

    public List<FeaturedTv> findAllTv() {

        return featuredTvRepository.findAll();
    }
}