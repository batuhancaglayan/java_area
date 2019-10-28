package com.spring.hystrix.tryer.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.hystrix.tryer.deneme.DenemeCommand;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommand.Setter;
import com.netflix.hystrix.HystrixCommandProperties;

@Configuration
public class AppConfig {
	
	@PostConstruct
	private void init() {
		System.err.println();
		//Setter setter = HystrixCommandProperties.defaultSetter();
	}
	
	
	
//	
//    @Bean
//    public DenemeCommand denemeCommand() {
//		return null;
//	}
}
