package com.garbage.spring.tryer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.garbage.spring.tryer.model.ContainerClass;

@SpringBootApplication
public class SpringGarbageTryerApplication implements CommandLineRunner {

	@Autowired
	private ContainerClass containerClass;

	public static void main(String[] args) {
		SpringApplication.run(SpringGarbageTryerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		String name = "deneme";
		int loop = 0;
		while (true) {
			loop++;
			containerClass.trigger(name + loop);
		}
	}

}
