package com.renatachom.springsecurity.controller.dto;

public record LoginRequest(String username, String password) {

    public CharSequence getPassword() {
       
        throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
    }

    public String getUsername() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
    }

}
