package com.boot.docker.tryer.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Log4j2(topic = "AppLogs")
@RestController
public class DenemeController {

	@GetMapping("/deneme")
	public String deneme() {
		Date date = new Date();
		log.debug("deneme log => " + date.toString());
		return "deneme";
	}
}
