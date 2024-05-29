package com.example.atividades.atividade07;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class TestUserService {

    @Test
    public void testSaveUser() {
    	// Create a mock for Database
    	Database mockedDatabase = mock(Database.class);
    	UserService userService = new UserService(mockedDatabase);
    	User user = new User("Renata Moreno", "renatachom.dev@gmail.com");

    	// Call the saveUser method
    	userService.saveUser(user);

    	// Verify if the saveUser method was called correctly on the Database mock
    	verify(mockedDatabase, times(1)).saveUser(user);
    }
}
