package com.multithread.share.tryer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.multithread.share.tryer.queue.BlockingQueue;

@Configuration
public class AppConfig {

	@Bean
	public BlockingQueue<String> getBlockingQueue() {
		return new BlockingQueue<String>(5);
	}
}
