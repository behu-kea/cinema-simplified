package com.example.cinema.repositories;

import com.example.cinema.models.MovieCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class RepositoryTest {
    @Autowired
    MovieCategoryRepository movieCategoryRepository;

    @Test
    @Sql("/create-movie-category.sql")
    public void testCount(){
        long result = movieCategoryRepository.count();
        assertEquals(2, result);
    }

    @Test
    @Sql("/create-movie-category.sql")
    public void testMovieCategoryName(){
        MovieCategory movieCategory = movieCategoryRepository.findById(1l).get();
        assertEquals("Horror", movieCategory.getName());
    }
}
