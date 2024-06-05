package com.example.atividades.atividade07;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestFakeDatabase {

    @Test
    public void testSaveUser() {
        // Arrange
        FakeDatabase fakeDatabase = new FakeDatabase();
        User user = new User("Renata Moreno", "renatachom.dev@gmail.com");

        // Act
        fakeDatabase.saveUser(user);

        // Assert
        assertTrue(fakeDatabase.isUserSaved(user));
    }
}
