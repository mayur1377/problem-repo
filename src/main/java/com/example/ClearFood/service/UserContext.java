package com.example.ClearFood.service;

import org.springframework.stereotype.Component;

import com.example.ClearFood.model.User;

@Component
public class UserContext {
    private User currentUser;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
