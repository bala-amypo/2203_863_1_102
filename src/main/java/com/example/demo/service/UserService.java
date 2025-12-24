package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User register(User user); // <-- add this
    List<User> getAllUsers();
    User getUserById(Long id);
    Optional<User> findByEmail(String email);
}
