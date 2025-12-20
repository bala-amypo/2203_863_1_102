package com.example.demo.util;

import org.springframework.stereotype.Component;

@Component
public class ModelValidator {
    
    public boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
    
    public boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }
}