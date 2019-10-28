package com.socket.socket.server.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThreadConfig {

	@Bean
	public ExecutorService getTaskExecutor() {
		return Executors.newFixedThreadPool(4);
	}
}
