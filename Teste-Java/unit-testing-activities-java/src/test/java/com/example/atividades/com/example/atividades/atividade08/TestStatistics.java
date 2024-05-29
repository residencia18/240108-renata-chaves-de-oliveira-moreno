package com.example.atividades.atividade08;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class TestStatistics {

    @Test
    public void testCalculateAverage() {
        Statistics statistics = new Statistics();
        
        //  Test with a valid number list
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        double average = statistics.calculateAverage(numbers);
        assertEquals(3.0, average);
    }

    @Test
    public void testCalculateAverageEmptyList() {
        Statistics statistics = new Statistics();
        
        // Test with an empty list of numbers
        List<Integer> numbers = Arrays.asList();
        assertThrows(IllegalArgumentException.class, () -> {
            statistics.calculateAverage(numbers);
        });
    }

    @Test
    public void testCalculateAverageNullList() {
        Statistics statistics = new Statistics();
        
        // Test with a null number list
        List<Integer> numbers = null;
        assertThrows(IllegalArgumentException.class, () -> {
            statistics.calculateAverage(numbers);
        });
    }
}
