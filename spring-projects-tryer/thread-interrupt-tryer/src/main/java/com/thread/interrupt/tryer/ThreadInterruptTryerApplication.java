package com.thread.interrupt.tryer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.thread.interrupt.tryer.trigger.Trigger;

@SpringBootApplication
public class ThreadInterruptTryerApplication implements CommandLineRunner {

	@Autowired
	private Trigger trigger;

	@Autowired
	private ThreadPoolTaskExecutor taskExecutor;

	public static void main(String[] args) {
		SpringApplication.run(ThreadInterruptTryerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		try {
			trigger.run();
		} catch (Exception e) {
			taskExecutor.shutdown();
			Runtime.getRuntime().addShutdownHook(new Thread() {
				public void run() {
					taskExecutor.shutdown();
				}
			});
		}

//		Thread t = new UsingInterruptToShutdownThread();
//		t.start();
//		Thread.sleep(5000);
//		t.interrupt();
	}
}
