package com.rechom.provaap.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    
    private final JavaMailSender emailSender;

    @Autowired
    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    
    }
    public void sendWelcomeEmail(String to, String username) {
        
        String subject = "Bem-vindo ao nosso aplicativo!";
        String text = "Olá " + username + ",\n\nBem-vindo ao nosso aplicativo!\n\n";
        text += "Essa é uma etapa da prova de JAVA-AVANÇADO TI18.\n";
        text += "Se tiver alguma dúvida, não hesite em nos contatar.\n";
        text += "Tenha uma ótima experiência!\n";
        
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        
        emailSender.send(message);
    }
    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
    
        emailSender.send(message);
    }
    
    public void sendPasswordRecoveryEmail(String to, String token) {
        String subject = "Recuperação de senha";
        String text = "Você solicitou a recuperação de senha. Clique no link a seguir para redefinir sua senha:\n\n";
        text += "http://localhost:8080/reset-password?token=" + token;
        
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        
        emailSender.send(message);
    }
    public Object sendPasswordResetEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendPasswordResetEmail'");
    }
    
}