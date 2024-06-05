package com.example.atividades.atividade02;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class TestIsEven {
    private final IsEven isEven = new IsEven();

    @Test
    public void testIsEvenWithEvenNumber() {
        assertTrue(isEven.isEven(2), "2 should be even");
    }

    @Test
    public void testIsEvenWithOddNumber() {
        assertFalse(isEven.isEven(3), "3 should be odd");
    }

    @Test
    public void testIsEvenWithZero() {
        assertTrue(isEven.isEven(0), "0 should be even");
    }

    @Test
    public void testIsEvenWithNegativeEvenNumber() {
        assertTrue(isEven.isEven(-4), "-4 should be even");
    }

    @Test
    public void testIsEvenWithNegativeOddNumber() {
        assertFalse(isEven.isEven(-5), "-5 should be odd");
    }
}
