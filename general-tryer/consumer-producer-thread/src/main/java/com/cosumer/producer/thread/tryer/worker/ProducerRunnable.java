package com.cosumer.producer.thread.tryer.worker;

import java.util.List;

public class ProducerRunnable implements Runnable {

	private List<Integer> sharedList;

	private int size;

	public ProducerRunnable(List<Integer> sharedList, int size) {
		this.sharedList = sharedList;
		this.size = size;
	}

	public void run() {

		for (int i = 0; i < 10; i++) {
			while (this.sharedList.size() == this.size) {
				synchronized (this.sharedList) {
					System.out.println("list is full producer waiting...");
					try {
						this.sharedList.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

			synchronized (this.sharedList) {
				System.out.println("producer produced => " + i);
				this.sharedList.add(i);
				this.sharedList.notifyAll();
			}
		}
	}
}
