package com.multithread.share.tryer.worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.multithread.share.tryer.queue.BlockingQueue;

@Component
@Scope("prototype")
public class ProducerRunnable implements Runnable {

	@Autowired
	private BlockingQueue<String> blockingQueue;

	@Override
	public void run() {
		int count = 0;
		while (true) {
			try {
				count++;
				this.blockingQueue.put("producer loop + " + count);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("producer loop + " + count + " finished");
		}
	}
}
