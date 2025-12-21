package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final List<User> users = new ArrayList<>();
    private Long idCounter = 1L;

    @Override
    public User addUser(User user) {
        user.setId(idCounter++);
        users.add(user);
        return user;
    }

    @Override
    public User getUser(Long id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }
}
