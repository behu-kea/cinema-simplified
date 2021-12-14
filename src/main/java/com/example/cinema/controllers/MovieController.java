package com.example.cinema.controllers;

import com.example.cinema.dtos.MovieDto;
import com.example.cinema.models.Movie;
import com.example.cinema.models.MovieCategory;
import com.example.cinema.models.Program;
import com.example.cinema.repositories.MovieCategoryRepository;
import com.example.cinema.repositories.MovieRepository;
import com.example.cinema.repositories.ProgramRepository;
import com.example.cinema.services.MovieCategoryService;
import com.example.cinema.services.MovieService;
import com.example.cinema.services.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:5500")
@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @Autowired
    MovieCategoryService movieCategoryService;

    @Autowired
    ProgramService programService;

    @GetMapping("movies/{id}")
    public MovieDto getMovie(@PathVariable Long id) {
        Movie foundMovie = movieService.findById(id);
        MovieDto movieDto = new MovieDto(foundMovie);
        return movieDto;
    }

    @GetMapping("movies")
    public List<MovieDto> getMovies() {
        return movieService.findAll().stream().map(MovieDto::new).collect(Collectors.toList());
    }

    @PostMapping("movies")
    public MovieDto getMovie(@RequestBody Movie movie) {
        Movie savedMovie = movieService.save(movie);
        MovieDto movieDto = new MovieDto(savedMovie);
        return movieDto;
    }

    @PutMapping("/add-category/{movieId}/{categoryId}")
    public MovieDto addCategoryToMovie(@PathVariable Long movieId, @PathVariable Long categoryId) {
        Movie movie = movieService.findById(movieId);
        MovieCategory movieCategory = movieCategoryService.findById(categoryId);

        movie.addCategory(movieCategory);
        Movie savedMovie = movieService.save(movie);
        return new MovieDto(savedMovie);
    }

    @PutMapping("programs/add-movie/{movieId}/{programId}")
    public Program addMovieToProgram(@PathVariable Long movieId, @PathVariable Long programId) {
        Movie movie = movieService.findById(movieId);
        Program program = programService.findById(programId);

        movie.setProgram(program);
        movieService.save(movie);
        return program;
    }

}
