package com.spring.hystrix.tryer.deneme;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.spring.hystrix.tryer.cache.DenemeCache;

@Component
@Scope("prototype")
public class TriggerCallable implements Callable<Void> {

	private int counter = 1;

	@Autowired
	private Deneme deneme;

	@Autowired
	private DenemeCache denemeCache;

	private ApplicationContext applicationContext;

	@Override
	public Void call() {
		while (true) {
//			if (counter % 100 == 0) {
//				this.refreshConnection();
//			}
			
			synchronized (deneme) {
				try {
					boolean state = false;
					if (counter % 7 == 0) {
						state = true;
						System.err.println("call state =>" + state);
					}

					this.deneme.put(state);
					this.denemeCache.get("aq");
//					System.err.println(
//							"TriggerCallable => " + Thread.currentThread().getName() + " => " + LocalDateTime.now());
					counter = counter + 1;
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		}
	}

	public void refreshConnection() {
		synchronized (deneme) {
			deneme.kill();
			deneme = null;
			deneme = this.applicationContext.getBean(Deneme.class);
			System.out.println("refreshConnection");
		}
	}
}
