package com.rechom.provaap.service;

import com.rechom.provaap.model.User;
import com.rechom.provaap.service.AuthorizationService;
import com.rechom.provaap.services.EmailService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.platform.commons.annotation.Testable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class AuthorizationServiceTest {

    @InjectMocks
    private com.rechom.provaap.services.AuthorizationService authorizationService;

    @Mock
    private EmailService emailService;

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Testable
    public void testSendPasswordResetEmail() {
        String email = "user@example.com";
        when(emailService.sendPasswordResetEmail(email)).thenReturn(true);

        boolean emailSent = authorizationService.sendPasswordResetEmail(email);

        org.springframework.util.Assert.assertTrue(emailSent);
        verify(emailService, times(1)).sendPasswordResetEmail(email);
    }

    @org.junit.jupiter.api.Test
    public void testSendPasswordResetEmail_Failure() {
        String email = "invalid@example.com";
        when(emailService.sendPasswordResetEmail(email)).thenReturn(false);

        boolean emailSent = authorizationService.sendPasswordResetEmail(email);

        Assertions.assertFalse(emailSent);
        verify(emailService, times(1)).sendPasswordResetEmail(email);
    }

    // Outros testes podem ser adicionados conforme necessário
}
