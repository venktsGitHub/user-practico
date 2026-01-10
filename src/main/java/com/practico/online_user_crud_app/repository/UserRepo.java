package com.practico.online_user_crud_app.repository;

import com.practico.online_user_crud_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {


}
