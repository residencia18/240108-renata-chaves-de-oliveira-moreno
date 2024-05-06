package com.renatachom.ap002.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    
    private final String remetente;
    
    public EmailService(@Value("${spring.mail.username}") String remetente) {
        this.remetente = remetente;
    }
    
    public String enviarEmailTexto(String destinatario, String assunto, String mensagem) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(remetente);
            simpleMailMessage.setTo(destinatario);
            simpleMailMessage.setSubject(assunto);
            simpleMailMessage.setText(mensagem);
            javaMailSender.send(simpleMailMessage);
            return "Email enviado";
        } catch (MailException e) {
            // Melhorando o tratamento de exceção para fornecer detalhes adequados
            return "Erro ao tentar enviar email: " + e.getMessage();
        }
    }

    public void sendPasswordRecoveryEmail(String email, String token) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendPasswordRecoveryEmail'");
    }
}
