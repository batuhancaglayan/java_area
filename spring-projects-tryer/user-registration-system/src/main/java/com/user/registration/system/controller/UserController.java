package com.user.registration.system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.user.registration.system.model.UserModel;

@RestController
public class UserController {

	public ResponseEntity<?> registerUser(UserModel user) {
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	public ResponseEntity<?> activateUser(UserModel user) {
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}
