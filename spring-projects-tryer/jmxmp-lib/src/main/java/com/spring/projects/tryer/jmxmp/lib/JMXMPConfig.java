package com.spring.projects.tryer.jmxmp.lib;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jmx.support.ConnectorServerFactoryBean;

@Configuration
@Profile(value = "jmx")
@PropertySource("jmx.properties")
public class JMXMPConfig {

	@Value("${jmx.protocol}")
	private String protocol;

	@Value("${jmx.host}")
	private String host;

	@Value("${jmx.port}")
	private int port;
	
	@Bean
	public ConnectorServerFactoryBean connectorServerFactoryBean() throws Exception {
		final ConnectorServerFactoryBean connectorServerFactoryBean = new ConnectorServerFactoryBean();
		String jmxURL = "service:jmx:" + protocol + "://" + host + ":" + port + "/";
		connectorServerFactoryBean.setServiceUrl(jmxURL);
		return connectorServerFactoryBean;
	}
}
