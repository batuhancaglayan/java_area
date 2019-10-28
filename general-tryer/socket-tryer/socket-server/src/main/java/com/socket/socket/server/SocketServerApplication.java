package com.socket.socket.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.socket")
public class SocketServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocketServerApplication.class, args);
	}
}
