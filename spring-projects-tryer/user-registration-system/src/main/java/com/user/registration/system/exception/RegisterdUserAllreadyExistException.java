package com.user.registration.system.exception;

public class RegisterdUserAllreadyExistException extends Exception {

	private static final long serialVersionUID = 1L;

	public RegisterdUserAllreadyExistException(String message) {
		super(message);
	}
}
