package com.group.registry.manager.worker;

import java.util.concurrent.Callable;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.group.registry.manager.model.SeviceSetting;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Lazy
@Component
@Scope("prototype")
public class QueueWorker implements Callable<Void>{

	@Autowired
	private SeviceSetting seviceSetting;
	
	@PostConstruct
	private void init() {
		log.info("QueueWorker created");
	}
	
	@Override
	public Void call() throws Exception {
		while (true) {
			int currentLoad = this.seviceSetting.getCurrentServiceLoad();
			log.info("current load => " + currentLoad);
			Thread.currentThread().sleep(5000);
		}
	}
}
