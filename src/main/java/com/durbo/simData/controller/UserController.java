package com.durbo.simData.controller;

import com.durbo.simData.model.User;
import com.durbo.simData.service.TokenService;
import com.durbo.simData.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;


    @GetMapping("/users")
    public Iterable<User> getUsers() {
        log.info("Getting users");
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        log.info("Getting user");
        Optional<User> user = userService.getUser(id);
        return user.orElse(null);
    }

    @GetMapping("/user/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        log.info("Getting user by email");
        Optional<User> user = userService.getUserByEmail(email);
        return user.orElse(null);
    }

    @GetMapping("/user/token/{token}")
    public User getUserFromToken(@PathVariable String token) {
        log.info("Getting user from token");
        return tokenService.getUserFromToken(token);
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable Long id, User user) {
        log.info("Updating user");
        Optional<User> userOptional = userService.getUser(id);
        if (userOptional.isPresent()) {
            User userToUpdate = userOptional.get();
            userToUpdate.setUsername(user.getUsername());
            userToUpdate.setPassword(user.getPassword());
            userToUpdate.setEmail(user.getEmail());
            return userService.saveUser(userToUpdate);
        }
        return null;
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        log.info("Creating user");
        return userService.saveUser(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        log.info("Deleting user");
        userService.deleteUser(id);
    }
}
