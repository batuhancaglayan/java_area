package com.aws.sns.tryer.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aws.sns.tryer.listener.SnsListener;

@RestController
public class DenemeController {

	@Autowired
	private SnsListener snsListener;

	@GetMapping("/")
	public String deneme() {
		this.snsListener.pushMessage("deneme-sns-message => " + new Date());
		return "deneme";
	}
}
