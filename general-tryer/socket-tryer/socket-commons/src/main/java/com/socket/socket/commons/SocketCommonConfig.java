package com.socket.socket.commons;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.ip.tcp.serializer.AbstractByteArraySerializer;
import org.springframework.integration.ip.tcp.serializer.TcpCodecs;

@Configuration
public class SocketCommonConfig {

	public interface MyGateway {

		String exchange(String out);
	}

	@Bean
	public AbstractByteArraySerializer codec() {
		return TcpCodecs.lf();
	}
}
