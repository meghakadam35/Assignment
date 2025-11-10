package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projects.entity.User;
import com.example.repository.userRepositoryInterface;

@RestController
@RequestMapping("/api/users")  
public class userController {

    @Autowired
    private userRepositoryInterface userRepository;

    // Creating new user
    @PostMapping
    public User createUser(@Valid @RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    // List of a ALL Users
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //get particular userId
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

   // Updating the project
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userData) {
        userData.setId(id);
        return userRepository.save(userData);
    }

    // Deleting the project content
    
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "User deleted successfully with ID: " + id;
    }
}
