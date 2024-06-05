package com.example.atividades.atividade07;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class TestDatabase {

    @Test
    public void testSaveUser() {
        // Arrange
        FakeDatabase fakeDatabase = new FakeDatabase();
        Database database = new Database(fakeDatabase);
        User user = new User("Renata Moreno", "renatachom.dev@gmail.com");

        // Act: Chamar o método saveUser
        database.saveUser(user);

        // Assert: Verificar se o usuário foi salvo corretamente
        assertTrue(database.getUsers().contains(user));
    }
}