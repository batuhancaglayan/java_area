package com.aspect.annotation.tryer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aspect.annotation.tryer.annotation.UserCheck;

@RestController
public class DenemeController {

	@UserCheck
	@GetMapping
	public String deneme() {
		return "dale";
	}
}
