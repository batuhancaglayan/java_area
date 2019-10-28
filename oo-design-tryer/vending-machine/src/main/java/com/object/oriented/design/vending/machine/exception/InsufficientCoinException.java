package com.object.oriented.design.vending.machine.exception;

public class InsufficientCoinException extends Exception {

	private static final long serialVersionUID = 1L;

	public InsufficientCoinException(String message) {
		super(message);
	}
}
