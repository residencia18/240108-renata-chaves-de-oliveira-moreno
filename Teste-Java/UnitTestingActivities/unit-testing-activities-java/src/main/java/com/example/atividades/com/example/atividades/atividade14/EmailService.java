package com.example.atividades.atividade14;

public class EmailService {
    public void sendEmail(String recipient, String subject, String body) {
        if (recipient == null || subject == null || body == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        // Simulate email sending
        System.out.println("Email sent to " + recipient + " with subject " + subject);
    }
}
