package com.spring.multithread.tryer.config;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import com.spring.multithread.tryer.model.DenemeItem;
import com.spring.multithread.tryer.worker.DenemeCallable;

@Configuration
public class ThreadpoolConfig {

	private int corePoolSize = 10;

	private int maxPoolSize = 10;

	@Bean
	public ExecutorService getExecutorService() {
		return Executors.newFixedThreadPool(10);
	}
	
//	@Bean
//	public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
//		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//		executor.setCorePoolSize(corePoolSize);
//		executor.setMaxPoolSize(maxPoolSize);
//		executor.setThreadNamePrefix("Worker-");
//		executor.initialize();
//
//		return executor;
//	}

	@Bean
	@Scope("prototype")
	public DenemeCallable getDenemeCallable(List<DenemeItem> denemeItem) {
		return new DenemeCallable(denemeItem);
	}
}
