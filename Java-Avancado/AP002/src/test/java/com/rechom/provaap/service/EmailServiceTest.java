package com.rechom.provaap.service;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.rechom.provaap.services.EmailService;

@ExtendWith(MockitoExtension.class)
public class EmailServiceTest {

    @Mock
    private JavaMailSender emailSenderMock;

    @InjectMocks
    private EmailService emailService;

    @BeforeEach
    public void setUp() {
        // Reset mock before each test
        reset(emailSenderMock);
    }

    @Test
    public void testSendWelcomeEmail() {
        // Arrange
        String to = "recipient@example.com";
        String username = "John";
        String expectedSubject = "Bem-vindo ao nosso aplicativo!";
        String expectedText = "Olá John,\n\nBem-vindo ao nosso aplicativo!\n\n"
                + "Essa é uma etapa da prova de JAVA-AVANÇADO TI18.\n"
                + "Se tiver alguma dúvida, não hesite em nos contatar.\n"
                + "Tenha uma ótima experiência!\n";

        // Act
        emailService.sendWelcomeEmail(to, username);

        // Assert
        verify(emailSenderMock).send(argThat(message ->
            message.getTo()[0].equals(to) &&
            message.getSubject().equals(expectedSubject) &&
            message.getText().equals(expectedText)
        ));
    }

    @Test
    public void testSendSimpleMessage() {
        // Arrange
        String to = "recipient@example.com";
        String subject = "Test Subject";
        String text = "Test Message";

        // Act
        emailService.sendSimpleMessage(to, subject, text);

        // Assert
        verify(emailSenderMock).send(argThat(message ->
            message.getTo()[0].equals(to) &&
            message.getSubject().equals(subject) &&
            message.getText().equals(text)
        ));
    }

    @Test
    public void testSendPasswordRecoveryEmail() {
        // Arrange
        String to = "recipient@example.com";
        String token = "abcd1234";
        String expectedSubject = "Recuperação de senha";
        String expectedText = "Você solicitou a recuperação de senha. Clique no link a seguir para redefinir sua senha:\n\n"
                + "http://localhost:8080/reset-password?token=" + token;

        // Act
        emailService.sendPasswordRecoveryEmail(to, token);

        // Assert
        verify(emailSenderMock).send(argThat(message ->
            message.getTo()[0].equals(to) &&
            message.getSubject().equals(expectedSubject) &&
            message.getText().equals(expectedText)
        ));
    }
}
