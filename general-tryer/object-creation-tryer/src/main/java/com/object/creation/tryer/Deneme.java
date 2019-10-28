package com.object.creation.tryer;

import lombok.Getter;

@Getter
public class Deneme {

	static {
		System.out.println("aq");
	}

	private String name = "deneme";

	public void printParameter(String value) {
		System.out.println("value => " + value);
	}

	public int getPower(int value) {
		return value * value;
	}
}
