package com.practico.online_user_crud_app.controller;


import com.practico.online_user_crud_app.model.User;
import com.practico.online_user_crud_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User addUser(@RequestBody User user){

        return userService.addUser(user);
    }

    @GetMapping("/")
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

}
