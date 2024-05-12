package com.rechom.provaap.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.rechom.provaap.controllers.PasswordResetToken;
import com.rechom.provaap.domain.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    @Value("${token.expiration.passwordReset}") // Configuração do tempo de expiração do token de recuperação de senha
    private long passwordResetExpiration;

    public String generateToken(User user){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(user.getLogin())
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error while generating token", exception);
        }
    }

    public String generatePasswordResetToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            Instant expirationTime = Instant.now().plusMillis(passwordResetExpiration);
            String token = JWT.create()
                    .withIssuer("auth-api")
                    .withSubject("password-reset")
                    .withClaim("userId", user.getId()) 
                    .withExpiresAt(Date.from(expirationTime))
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error while generating password reset token", exception);
        }
    }

    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception){
            return "";
        }
    }

    public boolean validatePasswordResetToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .withSubject("password-reset")
                    .build()
                    .verify(token);
            return true;
        } catch (JWTVerificationException exception){
            return false;
        }
    }

    private Instant genExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
