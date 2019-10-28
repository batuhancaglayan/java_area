package com.deneme.registry.client.tryer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
public class ServiceRegistryClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryClientApplication.class, args);
	}

}

