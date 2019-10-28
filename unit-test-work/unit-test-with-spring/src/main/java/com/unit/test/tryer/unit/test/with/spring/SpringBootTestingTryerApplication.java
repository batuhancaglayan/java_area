package com.unit.test.tryer.unit.test.with.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.unit.test.tryer.unit.test.with.spring.entity")
@EnableJpaRepositories("com.unit.test.tryer.unit.test.with.spring.repository")
@SpringBootApplication
public class SpringBootTestingTryerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestingTryerApplication.class, args);
	}
}
