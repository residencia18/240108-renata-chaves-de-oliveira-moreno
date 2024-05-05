package com.renatachom.springsecurity.controller;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.renatachom.springsecurity.controller.dto.LoginRequest;
import com.renatachom.springsecurity.controller.dto.LoginResponse;
import com.renatachom.springsecurity.entities.Role;
import com.renatachom.springsecurity.entities.UserActivity;
import com.renatachom.springsecurity.repository.UserActivityRepository;
import com.renatachom.springsecurity.repository.UserRepository;


@RestController
public class TokenController {

    private final JwtEncoder jwtEncoder;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserActivityRepository userActivityRepository; 

    public TokenController(JwtEncoder jwtEncoder,
                           UserRepository userRepository,
                           BCryptPasswordEncoder passwordEncoder,
                           UserActivityRepository userActivityRepository) {
        this.jwtEncoder = jwtEncoder;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userActivityRepository = userActivityRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {

        var user = userRepository.findByUsername(loginRequest.username());

        if (user.isEmpty() || !user.get().isLoginCorrect(loginRequest, passwordEncoder)) {
            throw new BadCredentialsException("user or password is invalid!");
        }

        // Logging user activity on login
        var userActivity = new UserActivity();
        userActivity.setAction("Login");
        userActivity.setUserId(user.get().getUserId());
        userActivity.setTimestamp(Instant.now());
        userActivityRepository.save(userActivity);

        var now = Instant.now();
        var expiresIn = 300L;

        var scopes = user.get().getRoles()
                .stream()
                .map(Role::getName)
                .collect(Collectors.joining(" "));

        var claims = JwtClaimsSet.builder()
                .issuer("mybackend") 
                .subject(user.get().getUserId().toString())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .claim("scope", scopes)
                .build();

        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return ResponseEntity.ok(new LoginResponse(jwtValue, expiresIn));
    }
}
