package com.group.registry.manager.worker;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.group.registry.manager.util.DiscoveryManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@ConditionalOnBean(QueueWorker.class)
public class DiscoveryCheckScheduler {

	@Autowired
	private DiscoveryManager discoveryManager;
	
	@PostConstruct
	private void init() {
		log.info("DiscoveryCheckScheduler created");
	}

	@Scheduled(initialDelayString = "20000", fixedDelayString = "10000")
	public void execute() {
		log.info("DiscoveryCheckScheduler execute start");
		this.discoveryManager.checkPeers();
		log.info("DiscoveryCheckScheduler execute finish");
	}
}
