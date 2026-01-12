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

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User addUser(User user) {

        return userRepo.save(user);
    }

    public User findById(Long id) {
        return userRepo.findById(id).orElse(new User());
    }

    public List<User> findByCity(String city) {
        return userRepo.findByAddressCity(city);
    }

    public List<User> findByState(String state) {
        return userRepo.findByAddressState(state);
    }

    public List<User> findByUserName(String userName) {
        return userRepo.findByUserName(userName);
    }

    public List<User> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }


    public void deleteUser(Long id) {

        userRepo.deleteById(id);
    }

    public User updateUser(Long id, User updatedUser) {
        return userRepo.findById(id).map(user -> {
            user.setUserName(updatedUser.getUserName());
            user.setEmail(updatedUser.getEmail());

            if (updatedUser.getProfile() != null) {
                user.setProfile(updatedUser.getProfile());
            }
            if (updatedUser.getAddress() != null) {
                user.setAddress(updatedUser.getAddress());
            }

            return userRepo.save(user);
        }).orElse(null); // or throw exception if user not found
    }


}
