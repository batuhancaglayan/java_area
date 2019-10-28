package com.user.registration.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.user.registration.system.entity")
@EnableJpaRepositories("com.user.registration.system.repository")
@SpringBootApplication
public class UserRegistrationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRegistrationSystemApplication.class, args);
	}
}
