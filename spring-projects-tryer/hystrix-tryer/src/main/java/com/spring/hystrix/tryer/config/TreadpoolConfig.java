package com.spring.hystrix.tryer.config;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.netflix.hystrix.HystrixThreadPoolProperties;

@Configuration
public class TreadpoolConfig {

	private int corePoolSize = 4;

	private int maxPoolSize = 4;

	@PostConstruct
	private void init() {
		//HystrixThreadPoolProperties.Setter().withMaximumSize(4);
	}

	@Bean
	public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(corePoolSize);
		executor.setMaxPoolSize(maxPoolSize);
		executor.setThreadNamePrefix("Worker-");
		executor.initialize();

		return executor;
	}
}
