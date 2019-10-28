package com.registry.feign.client.tryer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.converters.Auto;
import com.registry.feign.client.tryer.client.Deneme;
import com.registry.feign.client.tryer.client.IDataProviderProxyFeignClient;

@SpringBootApplication
@EnableFeignClients
@RestController
@ComponentScan(value = {"com.registry.feign", " com.comodo.cwn"})
public class RegistryClientTryer2Application implements CommandLineRunner {

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private Deneme deneme;
	
	@Autowired
	private IDataProviderProxyFeignClient idataProviderProxyFeignClient;

	public static void main(String[] args) {
		SpringApplication.run(RegistryClientTryer2Application.class, args);
	}

	public void run(String... args) throws Exception {
//		try {
//			String result = deneme.get();
//			System.err.println(result);
//		} catch (Exception e) {
//			System.err.println(e.getMessage());
//		}
	}

	@GetMapping("/deneme")
	public String deneme(@RequestHeader("Authorization") String authorization) {
		try {
			//List<ServiceInstance> abc = this.discoveryClient.getInstances("restendpoint");
			String result = deneme.get(authorization);
//			Map<String, HashMap<String, Map<String, Map<String, Long>>>>  abc =
//					this.idataProviderProxyFeignClient.getTreeBasedThreatSummary(authorization, "", "");
			return result;
		} catch (Exception e) {
			return e.getMessage();
		}	
	}
}
