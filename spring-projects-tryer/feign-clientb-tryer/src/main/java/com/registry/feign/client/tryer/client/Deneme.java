package com.registry.feign.client.tryer.client;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient("restendpoint")
@RibbonClient(name="restendpoint") 
public interface Deneme {

	@GetMapping("/deneme/get")
	String get(@RequestHeader("Authorization") String authorization);
}
