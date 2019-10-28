package com.spring.projects.tryer.service.registry.client.config;

import javax.annotation.PostConstruct;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.spring.projects.tryer.service.registry.client.RegistryInstanceInfo;
import com.spring.projects.tryer.service.registry.client.RegistryRefreshTask;
import com.spring.projects.tryer.service.registry.client.ribbon.RibbonConfiguration;

import lombok.extern.java.Log;

@Configuration
@EnableEurekaClient
@EnableScheduling
@RibbonClients(defaultConfiguration = RibbonConfiguration.class)
@Log
public class RegistryConfig {

	@PostConstruct
	private void init() {
		log.info("RegistryConfig init");
	}
	
	@Bean
	@ConditionalOnBean(RegistryInstanceInfo.class)
	@ConditionalOnProperty(prefix = "eureka.client", name = "cwn-refresh-enabled", havingValue = "true")
	public RegistryRefreshTask registryRefreshTask(RegistryInstanceInfo registryInstanceInfo) {
		log.info("RegistryRefreshTask bean created");
		return new RegistryRefreshTask(registryInstanceInfo);
	}
}
