package com.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.entity.User;
import com.ecom.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    
    public void createUser(User user) {
    	userRepo.save(user);
    }

    public User getUserById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
    }

    public void updateUser(User user) {
        userRepo.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("User with id " + user.getId() + " not found"));
        userRepo.save(user);
    }

    public void deleteUser(Long id) {
        userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
        userRepo.deleteById(id);
    }
    private boolean verifyCredentials(String email, String password) {
        User user = userRepo.findByEmail(email);
        
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        
        return false;
    }

}
