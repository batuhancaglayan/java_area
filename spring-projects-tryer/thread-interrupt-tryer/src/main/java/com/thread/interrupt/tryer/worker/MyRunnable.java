package com.thread.interrupt.tryer.worker;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
//@Scope("prototype")
public class MyRunnable implements Runnable {

	private volatile Boolean shutdown = false;
	
	private String id;
	
	public MyRunnable(String id) {
		this.id = id;
	}

	@Override
	public void run() {
		while (!shutdown) {
			int i = 0;
//			while (true) {
//				i++;
//				if (i >= 1000000) {
//					break;
//				}
//
//				this.loop();
//			}

			System.out.print(".");
			System.out.flush();
			System.out.println(this.id);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				System.err.println();
				System.err.println("InterruptedException => " + ex.getMessage());
				System.err.println();
				Thread.currentThread().interrupt(); // very important
				break;
			}
		}

		System.out.println("Shutting down thread");
	}

	public void shutdown() {
		synchronized (shutdown) {
			this.shutdown = true;
		}
	}

	private void loop() {
		int i = 0;
		while (true) {
			i++;
			if (i >= 1000000000) {
				break;
			}
		}
	}
}
