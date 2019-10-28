package com.group.registry.manager;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.group.registry.manager.constant.AppConstant;

@EnableScheduling
@SpringBootApplication
public class RegistryGroupDispatcherApplication implements CommandLineRunner {

	@Autowired
	private Trigger trigger;
	
	public static void main(String[] args) {
		System.setProperty(AppConstant.DISCOVERYCLIENTIDENTIFIER, UUID.randomUUID().toString());
		SpringApplication.run(RegistryGroupDispatcherApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			this.trigger.run();
		} catch (Exception e) {
			// TODO: handle exception
		}	
	}
}
