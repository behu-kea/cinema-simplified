package com.example.cinema.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "movie")
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int ageLimit;
    private String title;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "program_id", referencedColumnName = "id")
    private Program program;

    @ManyToMany
    @JoinTable(
            name = "categories_in_movies",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<MovieCategory> categories = new HashSet<>();

    public Movie(int ageLimit, String title) {
        this.ageLimit = ageLimit;
        this.title = title;
    }

    public Movie() {
    }

    public void addCategory(MovieCategory category) {
        this.categories.add(category);
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Long getId() {
        return id;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public String getTitle() {
        return title;
    }

    public Set<MovieCategory> getCategories() {
        return categories;
    }

    public Program getProgram() {
        return program;
    }
}
