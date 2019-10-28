package com.fork.join.tryer.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

import com.fork.join.tryer.util.PoolUtil;

public class CustomRecursiveAction extends RecursiveAction {

	private static final int THRESHOLD = 4;

	private final String workload;

	private final long waitTime;

	public CustomRecursiveAction(String workload, long waitTime) {
		this.workload = workload;
		this.waitTime = waitTime;
	}

	@Override
	protected void compute() {
		if (this.waitTime != 0) {
			try {
				System.out.println("sleep => " + Thread.currentThread().getName());
				Thread.sleep(this.waitTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if (workload.length() > THRESHOLD) {
			ForkJoinTask.invokeAll(createSubtasks());
		} else {
			processing(workload);
		}
	}

	private List<CustomRecursiveAction> createSubtasks() {
		System.err.println("workload => " + this.workload);
		List<CustomRecursiveAction> subtasks = new ArrayList<>();

		String partOne = workload.substring(0, workload.length() / 3);
		String partTwo = workload.substring(workload.length() / 3, (workload.length() / 3) * 2);
		String partThree = workload.substring((workload.length() / 3) * 2, workload.length());

		subtasks.add(new CustomRecursiveAction(partOne, 0));
		subtasks.add(new CustomRecursiveAction(partTwo, workload.length() <= THRESHOLD ? 5000 : 0));
		subtasks.add(new CustomRecursiveAction(partThree, 0));

		return subtasks;
	}

	private void processing(String work) {
		String result = work.toUpperCase();
		System.out.println("This result - (" + result + ") - was processed by " + Thread.currentThread().getName());
		System.err.println(PoolUtil.forkJoinPool.getStealCount());
	}
}
