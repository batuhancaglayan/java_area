package com.deneme.registry.client.tryer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/deneme")
@RestController
public class DenemeController {
	
	@GetMapping("/get")
	public String get() {
		return "get";
	}

}
