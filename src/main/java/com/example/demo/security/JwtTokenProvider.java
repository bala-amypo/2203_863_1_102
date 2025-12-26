package com.example.demo.security;

import com.example.demo.config.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private final SecretKey key;
    private final long expiration;

    private static final String DEFAULT_SECRET =
            "THIS_IS_A_VERY_LONG_AND_SECURE_256_BIT_SECRET_KEY_123456";

    public JwtTokenProvider() {
        this.key = Keys.hmacShaKeyFor(DEFAULT_SECRET.getBytes());
        this.expiration = 86400000;
    }

    public JwtTokenProvider(JwtProperties properties) {
        this.key = Keys.hmacShaKeyFor(DEFAULT_SECRET.getBytes());
        this.expiration = 86400000;
    }

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

    public boolean validateToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String getEmailFromToken(String token) {
        return getClaims(token).getSubject();
    }

    public String getRoleFromToken(String token) {
        return getClaims(token).get("role", String.class);
    }
}
