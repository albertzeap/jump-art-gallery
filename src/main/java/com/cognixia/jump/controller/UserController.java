package com.cognixia.jump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.User;
import com.cognixia.jump.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepo;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/users")
    public ResponseEntity<?> getUsers(){

        List<User> users = userRepo.findAll();
        if(users.isEmpty()){
            return ResponseEntity.status(400).body("No users found");
        }

        return ResponseEntity.status(200).body(users);
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody User user){
        
        user.setId(null);

        user.setPassword(encoder.encode(user.getPassword()));

        User created = userRepo.save(user);

        return ResponseEntity.status(201).body(created);

    }
}
