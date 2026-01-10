package com.practico.online_user_crud_app.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.context.annotation.Primary;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    private long id;
    private String name;
    private byte age;
    private double salary;
    private String city;

}
