package com.deneme.zuul.tryer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ZuulTryerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulTryerApplication.class, args);
	}
}

