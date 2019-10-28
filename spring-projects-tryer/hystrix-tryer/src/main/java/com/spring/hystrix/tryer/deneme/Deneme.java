package com.spring.hystrix.tryer.deneme;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
@Scope("prototype")
public class Deneme {

	@Autowired
	private DenemeClient denemeClient;

	@HystrixCommand(fallbackMethod = "putFallback",
			commandProperties = {
			//@HystrixProperty(name = "coreSize", value = "4"),
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") })
	public void put(boolean state) throws Exception {
		this.denemeClient.process(state);
	}

	private void putFallback(boolean state, Throwable e) throws Exception {
		// com.netflix.hystrix.exception.HystrixTimeoutException
		System.err.println("putFallback => " + state + " => " + Thread.currentThread().getName() + " => "
				+ LocalDateTime.now() + " => " + e.getMessage());
	}
	
	public void kill() {
		this.denemeClient.kill();
	}
}
