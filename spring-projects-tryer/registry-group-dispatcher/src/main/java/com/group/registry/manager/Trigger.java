package com.group.registry.manager;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import com.group.registry.manager.util.DiscoveryManager;
import com.group.registry.manager.worker.QueueWorker;

@Component
public class Trigger {

	private Future<Void> worker;
	
	@Autowired
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;
	
	@Autowired
	private ApplicationContext applicationContext;
		
	@Autowired
	private DiscoveryManager discoveryManager;
	
	public void run() {
		this.discoveryManager.checkPeers();
		this.worker = this.threadPoolTaskExecutor.submit(this.applicationContext.getBean(QueueWorker.class));
	}
}
