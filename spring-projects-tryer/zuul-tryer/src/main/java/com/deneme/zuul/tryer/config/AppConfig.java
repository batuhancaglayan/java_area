package com.deneme.zuul.tryer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.deneme.zuul.tryer.filter.GatewayPostFilter;
import com.deneme.zuul.tryer.filter.GatewayPreFilter;
import com.deneme.zuul.tryer.filter.GatewayRouteFilter;

@Configuration
@ComponentScan("com.comodo.cwn")
public class AppConfig {

	@Bean
	public GatewayPostFilter gatewayPostFilter() {
		return new GatewayPostFilter();
	}

	@Bean
	public GatewayPreFilter gatewayPreFilter() {
		return new GatewayPreFilter();
	}

	@Bean
	public GatewayRouteFilter gatewayRouteFilter() {
		return new GatewayRouteFilter();
	}
}
