package com.user.role.tryer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EntityScan(basePackages = "com.user.role.tryer.entity.wrapper")
@EnableJpaRepositories(basePackages = "com.user.role.tryer.repository.wrapper")
@ComponentScan("com.user.role.tryer")
@SpringBootApplication
public class UserRoleTryerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRoleTryerApplication.class, args);
	}
}
