package com.example.demo.config;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class JwtProperties {
    private String secret = "Bhavana";
    private Long expirationMs = 3600000L;
}