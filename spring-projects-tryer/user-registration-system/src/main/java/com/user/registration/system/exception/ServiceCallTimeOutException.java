package com.user.registration.system.exception;

public class ServiceCallTimeOutException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServiceCallTimeOutException(String message) {
		super(message);
	}
}
