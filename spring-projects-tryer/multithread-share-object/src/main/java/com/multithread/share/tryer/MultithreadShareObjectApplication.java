package com.multithread.share.tryer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.multithread.share.tryer.deneme.Trigger;

@SpringBootApplication
public class MultithreadShareObjectApplication implements CommandLineRunner {

	@Autowired
	private Trigger trigger;

	public static void main(String[] args) {
		SpringApplication.run(MultithreadShareObjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.trigger.run();
	}
}
