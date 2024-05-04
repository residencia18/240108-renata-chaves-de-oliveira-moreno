package com.renatachom.springsecurity.controller.dto;

public record LoginResponse(String accessToken, Long expiresIn) {
}
