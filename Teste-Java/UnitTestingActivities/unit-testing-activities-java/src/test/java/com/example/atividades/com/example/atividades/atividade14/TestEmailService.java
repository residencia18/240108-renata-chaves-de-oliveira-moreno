package com.example.atividades.atividade14;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestEmailService {

    @Test
    public void testSendEmail() {
        // Create an instance of EmailService
        EmailService emailService = new EmailService();

        // Call the sendEmail method with specific arguments
        emailService.sendEmail("test@example.com", "Subject", "Body");

        // Since the sendEmail method only prints to the console, there are no assertions to make
        // Verify the output visually or add additional logic as needed
    }

    @Test
    public void testSendEmailWithInvalidArguments() {
        // Create an instance of EmailService
        EmailService emailService = new EmailService();

        // Call the sendEmail method with invalid arguments and check for exception
        assertThrows(IllegalArgumentException.class, () -> {
            emailService.sendEmail(null, null, null);
        });
    }
}
