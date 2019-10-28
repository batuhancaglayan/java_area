package com.spring.multithread.tryer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SquareCalculator {

	private ExecutorService executor = Executors.newSingleThreadExecutor();

	public Future<Integer> calculate(Integer input) {
		return executor.submit(() -> {
			System.err.println("calculate submit");
			Thread.sleep(3000);
			return input * input;
		});
	}
	
	public void shutDown() {
		this.executor.shutdown();
	}
	
	public boolean checkStatusShutDown() {
		return this.executor.isShutdown();
	}
	
	public boolean checkStatusTerminated() {
		return this.executor.isTerminated();
	}
}
