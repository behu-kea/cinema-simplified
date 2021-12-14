package com.example.cinema.dtos;

import com.example.cinema.models.Movie;
import com.example.cinema.models.MovieCategory;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter
public class MovieDto {
    private String title;
    private int ageLimit;
    private Set<MovieCategory> categories = new HashSet<>();

    public MovieDto(Movie movie) {
        this.title = movie.getTitle();
        this.ageLimit = movie.getAgeLimit();
        this.categories = movie.getCategories();
    }
}
