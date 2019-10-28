package com.thread.interrupt.tryer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.thread.interrupt.tryer.worker.MyRunnable;

@Configuration
public class AppConfig {

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setThreadNamePrefix("Tryer worker-");
        executor.initialize();

        return executor;
    }
    
    @Bean
    @Scope("prototype")
    public MyRunnable myRunnable(String id) {
    	return new MyRunnable(id);
    }
}
