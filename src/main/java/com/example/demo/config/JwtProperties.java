package com.example.demo.config;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class JwtProperties {
    private String secret = "myVeryLongSecretKeyThatIsAtLeast32CharactersLongForSecurity";
    private Long expirationMs = 3600000L;
}