package com.renatachom.ap002.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.renatachom.ap002.service.TokenService;

@RestController
@RequestMapping("/api/password-reset")
public class PasswordResetController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserDetailsService userService;

    @PostMapping("/reset")
    public ResponseEntity<String> resetPassword(@RequestParam("token") String token, @RequestParam("password") String newPassword) {
        // Verificar se o token é válido e não expirou
        if (!tokenService.isTokenValid(token)) {
            return ResponseEntity.badRequest().body("Token inválido ou expirado");
        }
        
        // Verificar se o token expirou
        if (tokenService.isTokenExpired(token)) {
            tokenService.invalidateToken(token);
            return ResponseEntity.badRequest().body("Token expirado. Solicite um novo token de recuperação de senha.");
        }
        
        // Resetar a senha do usuário
        String email = tokenService.getEmailByToken(token);
        ((PasswordResetController) userService).resetPassword(email, newPassword);
        
        // Invalidar o token para que não possa ser reutilizado
        tokenService.invalidateToken(token);
        
        return ResponseEntity.ok("Senha redefinida com sucesso");
    }
}
