package com.group.registry.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@RestController
public class RegistryController {

	@Autowired
	private EurekaClient discoveryClient;
	
	@GetMapping
	public Application getItem(@RequestParam("appName") String appName) {
		Application application = this.discoveryClient.getApplication(appName);
		return application;
	}
}
