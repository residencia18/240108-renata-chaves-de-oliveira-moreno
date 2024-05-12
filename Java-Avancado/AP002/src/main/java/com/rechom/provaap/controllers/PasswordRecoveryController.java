package com.rechom.provaap.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rechom.provaap.domain.user.User;
import com.rechom.provaap.exceptions.UserNotFoundException;
import com.rechom.provaap.infra.security.TokenService;
import com.rechom.provaap.repositories.UserRepository;
import com.rechom.provaap.services.EmailService;

@RestController
public class PasswordRecoveryController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/password-recovery")
    public void requestPasswordRecovery(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        User user = userRepository.findByEmail(email);
        if (user != null) {
            String passwordResetToken = tokenService.generatePasswordResetToken(user);
            emailService.sendPasswordRecoveryEmail(email, passwordResetToken);
          
        } else {
            throw new UserNotFoundException("Usuário não encontrado");
        }
    }

    @PostMapping("/password-alter")
    public String alterPassword(@RequestBody PasswordChangeRequest request) {
        String email = request.getEmail();
        String newPassword = request.getNewPassword();
        
        User user = userRepository.findByEmail(email);
        if (user != null) {
            
            user.setPassword(newPassword);
            userRepository.save(user);
            return "Senha alterada com sucesso";
        } else {
            throw new UserNotFoundException("Usuário não encontrado");
        }
    }
}
