package com.example.atividades.atividade10;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class TestUserManager {

    @Test
    public void testFetchUserInfo_UserFound() {
        // Crie um mock para UserService
        UserService mockUserService = mock(UserService.class);

        // Crie um usuário para simular retorno do UserService
        User expectedUser = new User("John Doe", "john@example.com");
        when(mockUserService.getUserInfo(1)).thenReturn(expectedUser);

        // Crie uma instância de UserManager com o mock UserService
        UserManager userManager = new UserManager(mockUserService);

        // Chame o método fetchUserInfo
        User actualUser = userManager.fetchUserInfo(1);

        // Verifique se o método getUserInfo de UserService foi chamado com o ID de usuário correto
        verify(mockUserService, times(1)).getUserInfo(1);

        // Verifique se o usuário retornado é o mesmo que esperamos
        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void testFetchUserInfo_UserNotFound() {
        // Crie um mock para UserService
        UserService mockUserService = mock(UserService.class);

        // Simule que o UserService retorne null (usuário não encontrado)
        when(mockUserService.getUserInfo(1)).thenReturn(null);

        // Crie uma instância de UserManager com o mock UserService
        UserManager userManager = new UserManager(mockUserService);

        // Verifique se uma exceção é lançada quando o usuário não é encontrado
        assertThrows(RuntimeException.class, () -> {
            userManager.fetchUserInfo(1);
        });

        // Verifique se o método getUserInfo de UserService foi chamado com o ID de usuário correto
        verify(mockUserService, times(1)).getUserInfo(1);
    }
}
