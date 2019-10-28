package com.generic.search.service;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackages="com.generic.search.service")
@EnableJpaRepositories(basePackages="com.generic.search.service.repository")
@ComponentScan("com.generic")
public class SearchServiceApplication {
	
	public static void main(String[] args) {
		Date a = new Date();
		System.out.println(a.toString());
		SpringApplication.run(SearchServiceApplication.class, args);
	}
}
