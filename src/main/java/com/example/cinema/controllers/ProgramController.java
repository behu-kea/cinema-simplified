package com.example.cinema.controllers;

import com.example.cinema.models.Movie;
import com.example.cinema.models.Program;
import com.example.cinema.repositories.MovieRepository;
import com.example.cinema.repositories.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProgramController {
    @Autowired
    ProgramRepository programRepository;

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("programs/{id}")
    public Program getProgram(@PathVariable Long id) {
        return programRepository.findById(id).get();
    }

    @PostMapping("programs")
    public Program addProgram() {
        Program program = new Program("Fall program");
        Program savedProgram = programRepository.save(program);
        return savedProgram;
    }

/*
    @PutMapping("programs/add-movie/{movieId}/{programId}")
    public Program addMovieToProgram(@PathVariable Long movieId, @PathVariable Long programId) {
        Movie movie = movieRepository.findById(movieId).get();
        Program program = programRepository.findById(programId).get();

        program.addMovie(movie);
        programRepository.save(program);
        return program;
    }

 */
}
