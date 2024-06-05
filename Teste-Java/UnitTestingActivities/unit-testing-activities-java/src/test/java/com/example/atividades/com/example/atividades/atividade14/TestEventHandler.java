package com.example.atividades.atividade14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class TestEventHandler {

    @Mock
    private EmailService mockEmailService;

    private EventHandler eventHandler;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        eventHandler = new EventHandler(mockEmailService);
    }

    @Test
    public void testHandleEvent_ValidEvent() {
        // Chame o método handleEvent com um evento válido
        String event = "Valid event";
        eventHandler.handleEvent(event);

        // Verifique se o método sendEmail foi chamado corretamente
        verify(mockEmailService, times(1)).sendEmail(eq("test@example.com"), eq("Event Occurred"), eq(event));
    }

    @Test
    public void testHandleEvent_NullEvent() {
        // Chame o método handleEvent com um evento nulo
        eventHandler.handleEvent(null);

        // Verifique se o método sendEmail não foi chamado
        verify(mockEmailService, never()).sendEmail(anyString(), anyString(), anyString());
    }
}
