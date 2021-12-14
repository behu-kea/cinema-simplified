package com.example.cinema.controllers;

import com.example.cinema.dtos.MovieCategoryDto;
import com.example.cinema.errors.NotFoundException;
import com.example.cinema.models.Movie;
import com.example.cinema.models.MovieCategory;
import com.example.cinema.repositories.MovieCategoryRepository;
import com.example.cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class MovieCategoryController {
    @Autowired
    MovieCategoryRepository movieCategoryRepository;

    @GetMapping("movie-categories/{id}")
    public MovieCategory getCategoryMovie(@PathVariable Long id) {

        return movieCategoryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No name found for: " + id));
    }

    @GetMapping("movie-categories-dto/{id}")
    public MovieCategoryDto getCategoryMovieDto(@PathVariable Long id) {
        MovieCategory movieCategory = movieCategoryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No name found for: " + id));
        MovieCategoryDto movieCategoryDto = new MovieCategoryDto(movieCategory.getName());
        return movieCategoryDto;
    }

    @PostMapping("movie-categories")
    public MovieCategory getMovie() {
        MovieCategory movieCategory = new MovieCategory("Horror");
        System.out.println(movieCategory);
        MovieCategory savedMovieCategory = movieCategoryRepository.save(movieCategory);
        return savedMovieCategory;
    }


}
