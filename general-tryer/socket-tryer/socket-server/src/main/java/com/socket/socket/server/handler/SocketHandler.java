package com.socket.socket.server.handler;

import org.springframework.stereotype.Component;

@Component
public class SocketHandler {

	public String deneme(String payload) throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
		Thread.currentThread().sleep(10000);
		return "Hello " + payload;
	}
}
