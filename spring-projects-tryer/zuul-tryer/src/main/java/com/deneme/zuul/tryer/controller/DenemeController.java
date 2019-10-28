package com.deneme.zuul.tryer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class DenemeController {
	
	@Autowired
	private EurekaClient discoveryClient;
	
	@GetMapping("abc")
	public String abc() {
	    InstanceInfo instance = discoveryClient.getNextServerFromEureka("restendpoint", false);
	    return instance.getHomePageUrl();
	}

}
