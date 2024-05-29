package com.example.atividades.atividade07;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestDatabase {

    @Test
    public void testSaveUser() {
        Database database = new Database();
        User user = new User("Renata Moreno", "renatachom.dev@gmail.com");
        
        // Verifies that the saveUser method is called correctly
        assertDoesNotThrow(() -> {
            database.saveUser(user);
        });
    }
}
