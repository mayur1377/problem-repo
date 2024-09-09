package com.example.ClearFood.service;

import com.example.ClearFood.model.User;
import com.example.ClearFood.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> loginUser(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}