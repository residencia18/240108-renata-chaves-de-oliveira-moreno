package com.rechom.provaap.domain.user;

public record RegisterDTO(String login, String password, String email, UserRole role) {
}
