package com.spring.hystrix.tryer.deneme;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Service
//@EnableScheduling
//@Component
public class Trigger {

//	@Autowired
//	private Deneme deneme;

	private final List<Future<Void>> workers;
	
	private final List<Runnable> workerList;

	@Autowired
	private ThreadPoolTaskExecutor taskExecutor;

	@Autowired
	private ApplicationContext applicationContext;

	public Trigger() {
		this.workerList = new ArrayList<>();
		this.workers = new ArrayList<>();
	}

	public void run() throws Exception {
		this.initializeWorkers();
		while (true) {
			while (true) {
				this.make();
				Thread.sleep(30000);
			}
		}
	}

//	@Scheduled(fixedDelay = 5000)
//	public void scheduleFixedRateTask() throws InterruptedException, BrokenBarrierException {
//		System.out.println("Fixed rate task - " + LocalDateTime.now());
//		this.make();
//	}

	private void initializeWorkers() {
		for (int i = 0; i < 2; i++) {
			//this.workerList.add((Runnable) taskExecutor.submit(applicationContext.getBean(TriggerRunnable.class)));
			this.workers.add(taskExecutor.submit(applicationContext.getBean(TriggerCallable.class)));
		}
	}

	private void make() throws InterruptedException, BrokenBarrierException {
		System.err.println("make.....");
		for (int i = 0; i < workers.size(); i++) {
			Future<Void> worker = workers.get(i);
			if (worker.isDone()) {
				try {
					worker.get();
				} catch (ExecutionException ex) {
					System.err.println("make error");
				}

				workers.set(i, taskExecutor.submit(this.applicationContext.getBean(TriggerCallable.class)));
			}
		}
//
//		CyclicBarrier gate = new CyclicBarrier(21);
//		ExecutorService es = Executors.newCachedThreadPool();
//		for (int j = 0; j < 20; j++) {
//
//			boolean state;
//			if (j % 2 == 0) {
//				state = true;
//			} else {
//				state = false;
//			}
//
//			es.execute(new TriggerRunnable(deneme, state, gate));
//		}
//
//		gate.await();
//		es.shutdown();
//		System.err.println(Thread.currentThread().getName() + " => finished => " + LocalDateTime.now());
	}
}
