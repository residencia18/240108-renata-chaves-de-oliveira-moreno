package com.example.atividades.atividade06;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestPoint {

    @Test
    public void testDistanceToPositiveCoordinates() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(4, 6);
        assertEquals(5.0, p1.distanceTo(p2), 0.0001);
    }

    @Test
    public void testDistanceToSamePoint() {
        Point p1 = new Point(3, 4);
        assertEquals(0.0, p1.distanceTo(p1), 0.0001);
    }

    @Test
    public void testDistanceToNegativeCoordinates() {
        Point p1 = new Point(-1, -2);
        Point p2 = new Point(-4, -6);
        assertEquals(5.0, p1.distanceTo(p2), 0.0001);
    }

    @Test
    public void testDistanceToMixedCoordinates() {
        Point p1 = new Point(3, -4);
        Point p2 = new Point(-1, 2);
        assertEquals(7.2111, p1.distanceTo(p2), 0.0001);
    }

    @Test
    public void testDistanceToNullPoint() {
        Point p1 = new Point(1, 2);
        assertThrows(IllegalArgumentException.class, () -> {
            p1.distanceTo(null);
        });
    }
}

