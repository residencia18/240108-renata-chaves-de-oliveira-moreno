package com.example.atividades.atividade03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestFindMax {
    private final FindMax findMax = new FindMax();

    @Test
    public void testFindMaxWithNormalList() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(5, findMax.findMax(numbers));
    }

    @Test
    public void testFindMaxWithSingleElement() {
        List<Integer> numbers = Collections.singletonList(42);
        assertEquals(42, findMax.findMax(numbers));
    }

    @Test
    public void testFindMaxWithEmptyList() {
        List<Integer> numbers = Collections.emptyList();
        assertNull(findMax.findMax(numbers));
    }

    @Test
    public void testFindMaxWithNullList() {
        assertNull(findMax.findMax(null));
    }

    @Test
    public void testFindMaxWithNegativeNumbers() {
        List<Integer> numbers = Arrays.asList(-1, -2, -3, -4, -5);
        assertEquals(-1, findMax.findMax(numbers));
    }

    @Test
    public void testFindMaxWithMixedNumbers() {
        List<Integer> numbers = Arrays.asList(-10, 0, 10, 20, 5);
        assertEquals(20, findMax.findMax(numbers));
    }
}
