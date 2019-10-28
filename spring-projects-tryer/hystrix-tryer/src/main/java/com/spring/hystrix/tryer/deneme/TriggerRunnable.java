package com.spring.hystrix.tryer.deneme;

import java.util.concurrent.CyclicBarrier;

public class TriggerRunnable implements Runnable {

	private Deneme deneme;

	private boolean state;

	private CyclicBarrier gate;

	public TriggerRunnable(Deneme deneme, boolean state, CyclicBarrier gate) {
		this.deneme = deneme;
		this.state = state;
		this.gate = gate;
	}

	@Override
	public void run() {
		try {
			this.gate.await();
			this.deneme.put(this.state);
		} catch (Exception e) {
		}
	}
}
