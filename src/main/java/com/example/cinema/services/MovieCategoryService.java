package com.example.cinema.services;

import com.example.cinema.models.Movie;
import com.example.cinema.models.MovieCategory;
import com.example.cinema.repositories.MovieCategoryRepository;
import com.example.cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MovieCategoryService {
    @Autowired
    private MovieCategoryRepository movieCategoryRepository;

    public MovieCategory findById(Long id) {
        MovieCategory movieCategory = movieCategoryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No name found for: " + id));

        return movieCategory;
    }
}
