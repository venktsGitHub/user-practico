package com.practico.online_user_crud_app;

import com.practico.online_user_crud_app.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineUserCrudAppApplication {

	public static void main(String[] args) {

		User u = new User();
		u.setAge((byte)25);
		System.out.println(u.getAge());

		SpringApplication.run(OnlineUserCrudAppApplication.class, args);
	}

}
