package com.socket.socket.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.socket")
public class SocketClientApplication 
{
	public static void main(String[] args) {
		SpringApplication.run(SocketClientApplication.class, args);
	}
}