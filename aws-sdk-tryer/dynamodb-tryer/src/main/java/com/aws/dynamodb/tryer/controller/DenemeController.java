package com.aws.dynamodb.tryer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aws.dynamodb.tryer.connection.DynamodbConnection;

@RestController
public class DenemeController {

	@Autowired
	private DynamodbConnection dynamodbConnection;

	@GetMapping(value = "/")
	public String deneme() {
		this.dynamodbConnection.queryToItem();
		return "deneme";
	}
}
