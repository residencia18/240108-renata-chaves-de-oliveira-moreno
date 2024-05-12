package com.rechom.provaap.token;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.rechom.provaap.domain.user.User;
import com.rechom.provaap.domain.user.UserRole;
import com.rechom.provaap.infra.security.TokenService;

import java.time.Instant;
import java.time.temporal.ChronoUnit;



public class TokenServiceTest {

    @Test
    public void testGenerateToken() {
        TokenService tokenService = new TokenService();
        User user = new User("john_doe", "password", "maria@example.com", UserRole.USER);
        String token = tokenService.generateToken(user);
        assertNotNull(token);
    }

    @Test
    public void testGeneratePasswordResetToken() {
        TokenService tokenService = new TokenService();
        User user = new User("john_doe", "password", "maria@example.com", UserRole.USER);
        String token = tokenService.generatePasswordResetToken(user);
        assertNotNull(token);
    }

    @Test
    public void testValidateToken() {
        TokenService tokenService = new TokenService();
        User user = new User("john_doe", "password", "maria@example.com", UserRole.USER);
        String token = tokenService.generateToken(user);
        String username = tokenService.validateToken(token);
        assertEquals(user.getUsername(), username);
    }

    @Test
    public void testValidatePasswordResetToken() {
        TokenService tokenService = new TokenService();
        User user = new User("john_doe", "password", "maria@example.com", UserRole.USER);
        String token = tokenService.generatePasswordResetToken(user);
        assertTrue(tokenService.validatePasswordResetToken(token));
    }

    // Adicione mais testes conforme necessário
}
