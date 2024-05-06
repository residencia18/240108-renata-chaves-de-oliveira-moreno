package com.renatachom.ap002.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.renatachom.ap002.service.EmailService;
import com.renatachom.ap002.service.TokenService;
import com.renatachom.ap002.service.UsuarioService; 

@RestController
@RequestMapping("/api/password-recovery")
public class PasswordRecoveryController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UsuarioService usuarioService; 

    @PostMapping("/request")
    public ResponseEntity<String> requestPasswordRecovery(@RequestParam("email") String email) {
        // Verifique se o e-mail existe no banco de dados
        if (!usuarioService.emailExists(email)) {
            return ResponseEntity.badRequest().body("E-mail não encontrado");
        }
        
        String token = tokenService.generateToken(email);
        emailService.sendPasswordRecoveryEmail(email, token);
        return ResponseEntity.ok("E-mail de recuperação de senha enviado com sucesso");
    }
}
