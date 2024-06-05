package com.example.atividades.atividade10;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

public class TestUserService {

    @Test
    public void testGetUserInfo() {
        UserService userService = new UserService();
        assertNull(userService.getUserInfo(1)); // Nesse exemplo, estamos assumindo que o serviço externo retorna null para qualquer id de usuário.
    }
}
