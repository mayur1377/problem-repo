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

    @Autowired
    private UserContext userContext; 

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User loginUser(String phoneNumber) {
        Optional<User> userOptional = userRepository.findByPhoneNumber(phoneNumber);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            userContext.setCurrentUser(user);
            return user;
        }
        return null;
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}