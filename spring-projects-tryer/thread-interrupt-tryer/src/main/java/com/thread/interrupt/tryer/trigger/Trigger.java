package com.thread.interrupt.tryer.trigger;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import com.thread.interrupt.tryer.model.WorkerModel;
import com.thread.interrupt.tryer.worker.MyRunnable;
import com.thread.interrupt.tryer.worker.UsingInterruptToShutdownThread;

@Component
public class Trigger {

	private final List<WorkerModel<Void>> workerList;

	@Value("${concurrency.workerCount:2}")
	private int WORKER;

	@Autowired
	private ThreadPoolTaskExecutor taskExecutor;

	@Autowired
	private ApplicationContext applicationContext;

	public Trigger() {
		this.workerList = new ArrayList<>();
	}

	public void run() throws Exception {
		initializeWorkers();
		int count = 0;
		while (true) {
			checkWorkers();
			Thread.sleep(2000);
			if (count >= 4) {
				this.interruptWorker();
			}

			count++;
		}
	}

	private void initializeWorkers() {
		for (int i = 0; i < WORKER; i++) {

			// Thread newWorker = new Thread(new MyRunnable());

			Runnable newWorker = applicationContext.getBean(MyRunnable.class, UUID.randomUUID().toString());
			workerList.add(new WorkerModel<Void>((Future<Void>) taskExecutor.submit(newWorker), newWorker));
		}
	}

	private void checkWorkers() throws InterruptedException {
		for (int i = 0; i < workerList.size(); i++) {
			WorkerModel<Void> oldWorker = workerList.get(i);
			if (oldWorker.getTaskFucture().isDone()) {
				try {
					oldWorker.getTaskFucture().get();
				} catch (CancellationException ex) {
					System.err.println("CancellationException => " + ex.getMessage());
				} catch (ExecutionException ex) {
					System.err.println("ExecutionException => " + ex.getMessage());
				} catch (InterruptedException ex) {
					System.err.println("InterruptedException => " + ex.getMessage());
				} finally {
					// Thread newWorker = new Thread(new MyRunnable());
					Runnable newWorker = applicationContext.getBean(MyRunnable.class, UUID.randomUUID().toString());
					workerList.set(i, new WorkerModel<Void>((Future<Void>) taskExecutor.submit(newWorker), newWorker));
				}
			}
		}
	}

	private void interruptWorker() {
		for (int i = 0; i < workerList.size(); i++) {
			WorkerModel<Void> oldWorker = workerList.get(i);
			((MyRunnable) oldWorker.getTaskInstance()).shutdown();
		}
	}
}
