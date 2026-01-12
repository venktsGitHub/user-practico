package com.practico.online_user_crud_app.repository;

import com.practico.online_user_crud_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    // Find users by city
    List<User> findByAddressCity(String city);

    // Find users by state
    List<User> findByAddressState(String state);

    // Find users by username
    List<User> findByUserName(String userName);

    // Find users by email
    List<User> findByEmail(String email);


}
