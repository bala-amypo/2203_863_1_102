package com.example.demo.config;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class JwtProperties {
    private String secret = "myCustomSecretKeyForJWTThatIsAtLeast32CharactersLong";
    private Long expirationMs = 3600000L;
}