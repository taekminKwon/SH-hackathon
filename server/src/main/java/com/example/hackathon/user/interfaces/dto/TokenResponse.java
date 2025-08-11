package com.example.hackathon.user.interfaces.dto;

import lombok.Getter;

@Getter
public class TokenResponse {
    private final String token;

    public TokenResponse(String token) {
        this.token = token;
    }
}
