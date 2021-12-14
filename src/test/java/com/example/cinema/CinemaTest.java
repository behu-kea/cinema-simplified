package com.example.cinema;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CinemaTest {
    // junit
    @Test
    void testSomething() {
        int variableToTest = 1;
        assertEquals(1, variableToTest);
    }
}
