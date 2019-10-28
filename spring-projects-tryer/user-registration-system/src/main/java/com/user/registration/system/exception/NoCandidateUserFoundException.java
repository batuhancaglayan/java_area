package com.user.registration.system.exception;

public class NoCandidateUserFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoCandidateUserFoundException(String message) {
		super(message);
	}
}
