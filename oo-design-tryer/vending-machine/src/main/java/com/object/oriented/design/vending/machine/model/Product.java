package com.object.oriented.design.vending.machine.model;

public enum Product {

	COLA(15), CANDY(5);
	
	private int price;
	
	private Product(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
}
