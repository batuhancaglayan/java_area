package com.socket.socket.client.config;

import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Transformers;
import org.springframework.integration.ip.dsl.Tcp;
import org.springframework.integration.ip.tcp.serializer.AbstractByteArraySerializer;

import com.socket.socket.commons.SocketCommonConfig.MyGateway;

@Configuration
public class AppConfig {

	@Autowired
	private ExecutorService executorService;
	
	@Bean
	public IntegrationFlow client(AbstractByteArraySerializer codec) {
		return IntegrationFlows.from(MyGateway.class)
				.handle(Tcp.outboundGateway(Tcp.netClient("localhost", 1234).soKeepAlive(true).soTimeout(30000).serializer(codec) // CRLF
						.deserializer(codec).taskExecutor(this.executorService)).remoteTimeout(30000))
				.transform(Transformers.objectToString()).get();
	}

	@Bean
	@DependsOn("client")
	ApplicationRunner runner(MyGateway gateway) {
		return args -> {
			System.out.println(gateway.exchange("foo"));
			System.out.println(gateway.exchange("bar"));
		};
	}
}
