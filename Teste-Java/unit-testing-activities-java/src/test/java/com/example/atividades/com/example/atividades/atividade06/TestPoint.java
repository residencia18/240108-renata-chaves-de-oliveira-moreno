package com.example.atividades.atividade06;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestPoint {

    @Test
    public void testPointConstructor() {
        Point point = new Point(3, 4);

        assertEquals(3, point.getX());
        assertEquals(4, point.getY());
    }

    @Test
    public void testDistanceToSamePoint() {
        Point point1 = new Point(3, 4);
        Point point2 = new Point(3, 4);

        assertEquals(0.0, point1.distanceTo(point2));
    }

    @Test
    public void testDistanceToDifferentPoint() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(3, 4);

        assertEquals(5.0, point1.distanceTo(point2));
    }

    @Test
    public void testDistanceToNullPoint() {
        Point point = new Point(3, 4);
        Point nullPoint = null;

        assertThrows(IllegalArgumentException.class, () -> {
            point.distanceTo(nullPoint);
        });
    }
}
