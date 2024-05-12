package com.rechom.provaap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rechom.provaap.domain.user.User;
import com.rechom.provaap.infra.security.TokenService;
import com.rechom.provaap.repositories.UserRepository;

@RestController
public class PasswordResetController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/password-reset")
    public String resetPassword(@RequestBody PasswordResetRequest request) {
        String token = request.getToken();
        String newPassword = request.getNewPassword();
        
        // Validar o token
        boolean resetToken = tokenService.validatePasswordResetToken(token);
        if (resetToken == null) {
            throw new InvalidTokenException("Token inválido ou expirado");
        }
        
        // Resetar a senha do usuário
        User user = resetToken.getUser();
        user.setPassword(newPassword);
        userRepository.save(user);
        
        // Invalidar o token
        tokenService.invalidatePasswordResetToken(resetToken);
        
        return "Senha redefinida com sucesso";
    }
}
