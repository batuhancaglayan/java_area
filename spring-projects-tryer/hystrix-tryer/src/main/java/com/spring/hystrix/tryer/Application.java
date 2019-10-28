package com.spring.hystrix.tryer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.spring.hystrix.tryer.deneme.Trigger;

@EnableCircuitBreaker
@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private Trigger trigger;

	@Autowired
	private ThreadPoolTaskExecutor taskExecutor;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		try {
			this.trigger.run();
		} catch (Exception e) {
			taskExecutor.shutdown();
			Runtime.getRuntime().addShutdownHook(new Thread() {
				public void run() {
					taskExecutor.shutdown();
				}
			});

			System.err.println("Application is shutdown..");
		}
	}
}
