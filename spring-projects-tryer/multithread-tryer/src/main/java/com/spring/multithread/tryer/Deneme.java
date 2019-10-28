package com.spring.multithread.tryer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import com.spring.multithread.tryer.worker.DenemeCallable;

//@Component
public class Deneme {

	private final List<Future<Void>> workers;

	@Autowired
	private ThreadPoolTaskExecutor taskExecutor;

	@Autowired
	private ApplicationContext applicationContext;

	public Deneme() {
		this.workers = new ArrayList<>();
	}

	@PostConstruct
	private void init() throws InterruptedException, ExecutionException {
		
		SquareCalculator squareCalculator = new SquareCalculator();
		Future<Integer> future = squareCalculator.calculate(10);

		while (!future.isDone()) {
			System.out.println("Calculating...");
			Thread.sleep(300);
		}

		Integer result = future.get();
		System.err.println("resut => " + result);
		squareCalculator.shutDown();
		System.err.println(squareCalculator.checkStatusShutDown());
		System.err.println(squareCalculator.checkStatusTerminated());
	}
}
