package com.rechom.provaap.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rechom.provaap.domain.user.AuthenticationDTO;
import com.rechom.provaap.domain.user.LoginResponseDTO;
import com.rechom.provaap.domain.user.RegisterDTO;
import com.rechom.provaap.domain.user.User;
import com.rechom.provaap.infra.security.TokenService;
import com.rechom.provaap.repositories.UserRepository;
import com.rechom.provaap.services.EmailService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository repository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private EmailService emailService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.repository.findByLogin(data.login()) != null) 
            return ResponseEntity.badRequest().build();
    
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.email(), data.role());
    
        this.repository.save(newUser);
    
        // Envie um e-mail de boas-vindas para o novo usuário
        String emailBody = "Olá " + data.login() + ",\n\nBem-vindo a Prova Java - Avançado - TIC18";
        emailService.sendSimpleMessage(data.email(), "Bem-vindo!", emailBody);

        
    
        return ResponseEntity.ok().build();
    }
    
        @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = repository.findAll();
        return ResponseEntity.ok(users);
}

}
