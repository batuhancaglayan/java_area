package com.multithread.share.tryer.worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.multithread.share.tryer.queue.BlockingQueue;

@Component
@Scope("prototype")
public class ConsumerRunnable implements Runnable {

	@Autowired
	private BlockingQueue<String> blockingQueue;

	@Override
	public void run() {
		while (true) {
			try {
				String item = this.blockingQueue.take();
				System.out.println("consumer take => " + item);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
