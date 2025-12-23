package com.example.demo.util;

import com.example.demo.exception.ResourceNotFoundException;

public class ModelValidator {

    public static void validateNotNull(Object obj, String message) {
        if (obj == null) {
            throw new ResourceNotFoundException(message);
        }
    }

    public static void validateString(String value, String message) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateId(Long id, String message) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException(message);
        }
    }
}
