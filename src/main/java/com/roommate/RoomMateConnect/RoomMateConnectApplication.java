package com.roommate.RoomMateConnect;



import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.roommate.RoomMate_Connect.model.User;
import com.roommate.RoomMate_Connect.repository.UserRepository;

@SpringBootApplication(scanBasePackages = "com.roommate.RoomMate_Connect")
@EnableJpaRepositories("com.roommate.RoomMate_Connect.repository")
@EntityScan("com.roommate.RoomMate_Connect.model")


public class RoomMateConnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomMateConnectApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			userRepository.save(new User("testUser" , "password123"));
			System.out.println("User saved");
		};
	}
}
