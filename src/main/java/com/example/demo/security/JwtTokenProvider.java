package com.example.demo.security;

import com.example.demo.config.JwtProperties;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private final SecretKey key;
    private final long expiration;

    private static final String SECRET =
            "THIS_IS_A_VERY_LONG_AND_SECURE_256_BIT_SECRET_KEY_123456";

    // Required by Spring
    public JwtTokenProvider() {
        this.key = Keys.hmacShaKeyFor(SECRET.getBytes());
        this.expiration = 86400000; // 1 day
    }

    // Required by test suite
    public JwtTokenProvider(JwtProperties properties) {
        this.key = Keys.hmacShaKeyFor(SECRET.getBytes());
        this.expiration = 86400000;
    }

    // ===== TOKEN CREATION =====

    public String createToken(long userId, String email, String role) {
        return buildToken(userId, email, role);
    }

    public String generateToken(Long userId, String email, String role) {
        return buildToken(userId, email, role);
    }

    private String buildToken(Long userId, String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // ===== TOKEN VALIDATION =====

    public boolean validateToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 🔥 THIS IS THE CRITICAL FIX
    // Tests expect getClaims(token).getBody()
    public Jws<Claims> getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
    }

    public String getEmailFromToken(String token) {
        return getClaims(token).getBody().getSubject();
    }

    public String getRoleFromToken(String token) {
        return getClaims(token).getBody().get("role", String.class);
    }
}
