package com.spring.projects.tryer.service.registry.client;

import javax.annotation.PostConstruct;

import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.java.Log;

@Log
public class RegistryRefreshTask {

	private RegistryInstanceInfo registryInstanceInfo;
	
	public RegistryRefreshTask(RegistryInstanceInfo registryInstanceInfo) {
		this.registryInstanceInfo = registryInstanceInfo;
	}
	
	@PostConstruct
	private void init() {
		log.info("RegistryRefreshTask init");
	}

	@Scheduled(initialDelayString = "${eureka.client.cwn-initial-registry-time:60000}", fixedDelayString = "${eureka.client.cwn-refresh-registry-time:300000}")
	public void execute() {
		log.info("RegistryRefreshTask executed");
		this.registryInstanceInfo.refreshInfo();
	}
}
