package com.renatachom.ap002.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private Map<String, Object> tokenMap;
    private static final long TOKEN_EXPIRATION_TIME = 24 * 60 * 60 * 1000; // 24 horas em milissegundos

    public TokenService() {
        this.tokenMap = new HashMap<>();
    }

    public String generateToken(Object object) {
        String token = generateUniqueToken();
        tokenMap.put(token, object);
        return token;
    }

    public String getEmailByToken(String token) {
        Object object = tokenMap.get(token);
        if (object != null && object instanceof String) {
            return (String) object;
        }
        return null;
    }

    public void invalidateToken(String token) {
        tokenMap.remove(token);
    }

    public boolean isTokenValid(String token) {
        return tokenMap.containsKey(token);
    }

    // Adicionando expiração de token
    public boolean isTokenExpired(String token) {
        long tokenTime = Long.parseLong(token.split("-")[1]);
        return System.currentTimeMillis() - tokenTime > TOKEN_EXPIRATION_TIME;
    }

    private String generateUniqueToken() {
        return UUID.randomUUID().toString() + "-" + System.currentTimeMillis();
    }
}
