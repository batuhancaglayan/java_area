package com.multithread.share.tryer.deneme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import com.multithread.share.tryer.worker.ConsumerRunnable;
import com.multithread.share.tryer.worker.ProducerRunnable;

@Component
public class Trigger {

	@Autowired
	private ThreadPoolTaskExecutor taskExecutor;

	@Autowired
	private ApplicationContext applicationContext;

	public void run() {
		this.taskExecutor.submit(this.applicationContext.getBean(ProducerRunnable.class));
		this.taskExecutor.submit(this.applicationContext.getBean(ConsumerRunnable.class));
	}
}
