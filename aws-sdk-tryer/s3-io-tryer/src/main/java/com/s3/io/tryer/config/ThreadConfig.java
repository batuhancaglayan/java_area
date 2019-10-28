package com.s3.io.tryer.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThreadConfig {

	@Bean
	public ExecutorService getExecutorService() {		
		return Executors.newFixedThreadPool(10);
	}
}
