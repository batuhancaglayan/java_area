package com.socket.socket.server.config;

import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Transformers;
import org.springframework.integration.ip.dsl.Tcp;
import org.springframework.integration.ip.tcp.serializer.AbstractByteArraySerializer;

import com.socket.socket.server.handler.SocketHandler;

@Configuration
public class AppConfig {

	@Autowired
	private ExecutorService executorService;
	
	@Bean
	public IntegrationFlow server(AbstractByteArraySerializer codec) {
		return IntegrationFlows.from(Tcp.inboundGateway(Tcp.netServer(1235).soKeepAlive(true).soTimeout(30000).serializer(codec) // default is CRLF			
				.deserializer(codec).taskExecutor(this.executorService))) // default is CRLF
				
				.transform(Transformers.objectToString()) // byte[] -> String
				.<String, String>transform(p -> p.toUpperCase())
				.handle(this.getSocketHandler())
				.get();
	}
	
	
//	return IntegrationFlows.from(MyGateway.class)
//			.handle(
//					Tcp.outboundGateway(Tcp.netClient("localhost", 1234).serializer(codec()) // default is CRLF
//					.deserializer(codec()).id("server"))) // default is CRLF
//
//			.transform(Transformers.objectToString()) // byte[] -> String
//			.get();


	
	@Bean
	public SocketHandler getSocketHandler() {
		return new SocketHandler();
	}
}
