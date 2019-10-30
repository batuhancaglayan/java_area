package com.object.oriented.design.shopping.system.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

	private UUID productId;

	private double unitPrice;

	private int quantity;

	public int increaseQuantity() {
		return ++this.quantity;
	}

	public int decreaseQuantity() {
		return --this.quantity;
	}
}
