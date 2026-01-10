package com.practico.online_user_crud_app.service;


import com.practico.online_user_crud_app.model.User;
import com.practico.online_user_crud_app.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> getAllUsers(){


        return userRepo.findAll();
    }

    public User addUser(User user) {

        return userRepo.save(user);
    }
}
