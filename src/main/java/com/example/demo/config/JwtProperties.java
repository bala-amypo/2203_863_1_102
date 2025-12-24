package com.example.demo.config;

public class JwtProperties {
    private String secret;
    private long expirationMs;

    public String getSecret() {
        return secret;
    }

    public long getExpirationMs() {
        return expirationMs;
    }
}
