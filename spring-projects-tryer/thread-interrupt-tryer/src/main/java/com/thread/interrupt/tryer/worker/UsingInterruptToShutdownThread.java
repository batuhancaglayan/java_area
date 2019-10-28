package com.thread.interrupt.tryer.worker;

import java.util.concurrent.Callable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UsingInterruptToShutdownThread extends Thread {

	private volatile Boolean shutdown = false;
	
	@Override
	public void run() {
		while (!shutdown) {
			int i = 0;
			while (true) {
				i++;
				if (i >= 1000000000) {
					break;
				}
				
				this.loop();
			}
			
			System.out.print(".");
			System.out.flush();
			try {
				Thread.sleep(5000);
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
		synchronized(shutdown) {
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
