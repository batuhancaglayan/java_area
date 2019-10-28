package com.cosumer.producer.thread.tryer.worker;

import java.util.List;

public class CosumerRunnable implements Runnable {

	private List<Integer> sharedList;

	public CosumerRunnable(List<Integer> sharedList) {
		this.sharedList = sharedList;
	}

	public void run() {
		while (true) {
			while (sharedList.isEmpty()) {
				synchronized (this.sharedList) {
					System.out.println("list is empty consumer waiting...");
					try {
						sharedList.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

			synchronized (this.sharedList) {
				this.sharedList.notifyAll();
				System.out.println("consumer consumed => " + this.sharedList.get(0));
				this.sharedList.remove(this.sharedList.get(0));
			}
		}
	}
}
