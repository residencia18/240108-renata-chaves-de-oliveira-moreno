package com.renatachom.ap002.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomTokenService {

    private Map<String, String> tokenMap;

    public CustomTokenService() {
        this.tokenMap = new HashMap<>();
    }

    public String generateToken(String username) {
        String token = generateUniqueToken(username);
        tokenMap.put(username, token);
        return token;
    }

    public String getEmailByToken(String token) {
        for (Map.Entry<String, String> entry : tokenMap.entrySet()) {
            if (entry.getValue().equals(token)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void invalidateToken(String token) {
        tokenMap.entrySet().removeIf(entry -> entry.getValue().equals(token));
    }

    private String generateUniqueToken(String username) {
 
        return "generated-token";
    }
}
