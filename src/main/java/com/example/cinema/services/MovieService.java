package com.example.cinema.services;

import com.example.cinema.dtos.MovieDto;
import com.example.cinema.models.Movie;
import com.example.cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public Movie findById(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No name found for: " + id));

        return movie;
    }

    public Movie save(Movie movie) {
        Movie savedMovie = movieRepository.save(movie);

        return savedMovie;
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }
}
