package com.immutable.thread.share.tryer.worker;

public class DenemeWorker implements Runnable {

	private String value;

	private long sleepTime;

	private Thread thread;

	private String threadName;

	public DenemeWorker(String value, long sleepTime) {
		this.sleepTime = sleepTime;
		this.threadName = "thread" + sleepTime;
		this.value = value + this.threadName;
	}

	@Override
	public void run() {
		while (true) {

			try {
				System.out.println("old value => " + this.value);
				this.value = this.value + Thread.currentThread().getName();
				System.out.println("new value => " + this.value);
				Thread.currentThread();
				Thread.sleep(this.sleepTime);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	public void start() {
		System.out.println("Starting " + this.threadName);
		if (this.thread == null) {
			thread = new Thread(this, this.threadName);
			thread.start();
		}
	}
}
