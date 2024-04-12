package com.backend.backend.service;

import com.backend.backend.model.Tv;
import com.backend.backend.repository.TvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TvService {

    @Autowired
    private TvRepository tvRepository;

    public List<Tv> findAllTv() {
        return tvRepository.findAll();
    }
}