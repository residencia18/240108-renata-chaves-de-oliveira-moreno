package com.example.atividades.atividade10;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestUser {

    @Test
    public void testGetName() {
        String name = "John Doe";
        String email = "john@example.com";
        User user = new User(name, email);
        assertEquals(name, user.getName());
    }

    @Test
    public void testGetEmail() {
        String name = "John Doe";
        String email = "john@example.com";
        User user = new User(name, email);
        assertEquals(email, user.getEmail());
    }
}
