package com.example.atividades.atividade14;

public class EventHandler {
    private EmailService emailService;

    public EventHandler(EmailService emailService) {
        this.emailService = emailService;
    }

    public void handleEvent(String event) {
        if (event != null) {
            emailService.sendEmail("test@example.com", "Event Occurred", event);
        }
    }
}
