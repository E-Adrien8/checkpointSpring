package com.example.checkpointSpring.controllers;


import com.example.checkpointSpring.entity.User;
import com.example.checkpointSpring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepository repo;

    @GetMapping("/users")
    public List<User> list() {
        return repo.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUsers(@PathVariable Integer id) {
        Optional<User> optionalUser = repo.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/users")
    public User postUser(@RequestBody User user) {
        return repo.save(user);
    }

    @PutMapping("/users/{id}")
    public User update(@PathVariable Integer id, @RequestBody User user) {
        user.setId(id);
        return repo.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deletePost(@PathVariable Integer id) {
        repo.deleteById(id);
    }
}
