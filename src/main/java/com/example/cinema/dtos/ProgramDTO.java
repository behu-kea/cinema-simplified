package com.example.cinema.dtos;

import com.example.cinema.models.Movie;

import java.util.HashSet;
import java.util.Set;

public class ProgramDTO {
    private Set<Movie> movies = new HashSet<>();

    public ProgramDTO(Set<Movie> movies) {
        this.movies = movies;
    }
}
