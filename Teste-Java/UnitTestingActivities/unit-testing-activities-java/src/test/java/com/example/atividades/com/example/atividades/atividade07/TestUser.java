package com.example.atividades.atividade07;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestUser {

    @Test
    public void testUserConstructor() {
        User user = new User("Renata Moreno", "renatachom.dev@gmail.com");
        
        assertEquals("Renata Moreno", user.getName());
        assertEquals("renatachom.dev@gmail.com", user.getEmail());
    }
}
