package com.object.oriented.design.vending.machine.exception;

public class OutOfStockException extends Exception {

	private static final long serialVersionUID = 1L;

	public OutOfStockException(String message) {
		super(message);
	}
}