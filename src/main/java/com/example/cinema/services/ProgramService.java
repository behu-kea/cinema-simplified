package com.example.cinema.services;

import com.example.cinema.models.MovieCategory;
import com.example.cinema.models.Program;
import com.example.cinema.repositories.MovieCategoryRepository;
import com.example.cinema.repositories.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProgramService {
    @Autowired
    private ProgramRepository programRepository;

    public Program findById(Long id) {
        Program program = programRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No name found for: " + id));

        return program;
    }
}

