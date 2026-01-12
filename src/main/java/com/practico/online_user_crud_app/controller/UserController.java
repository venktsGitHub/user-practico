package com.practico.online_user_crud_app.controller;


import com.practico.online_user_crud_app.model.User;
import com.practico.online_user_crud_app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        log.debug("Received request to create user: {}", user);
        User savedUser = userService.addUser(user);
        log.info("User created with ID: {}", savedUser.getId());
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        log.debug("Received request to fetch all users");
        List<User> users = userService.getAllUsers();
        log.info("Fetched {} users", users.size());
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        log.debug("Received request to fetch all users");
        User user = userService.findById(id);
        log.info("Fetched {} users", user.toString());
        return ResponseEntity.ok(user);
    }

    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsers(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) String email) {

        if (city != null) {
            return ResponseEntity.ok(userService.findByCity(city));
        } else if (state != null) {
            return ResponseEntity.ok(userService.findByState(state));
        } else if (userName != null) {
            return ResponseEntity.ok(userService.findByUserName(userName));
        } else if (email != null) {
            return ResponseEntity.ok(userService.findByEmail(email));
        } else {
            return ResponseEntity.ok(userService.getAllUsers());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User with ID " + id + " deleted successfully");
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = userService.updateUser(id, updatedUser);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




}
