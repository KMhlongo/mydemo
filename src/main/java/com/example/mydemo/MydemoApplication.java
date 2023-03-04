package com.example.mydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MydemoApplication {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(MydemoApplication.class, args);
	}

	@GetMapping("count")
	public String getusers() {
		int num = (int) userRepository.count();
		return "Number of users = " + num;
	}

	@GetMapping("addUser")
	public String addUser() {
		User user = new User();
		user.setName("New User");
		userRepository.save(user);
		return "New user added";
	}

}
