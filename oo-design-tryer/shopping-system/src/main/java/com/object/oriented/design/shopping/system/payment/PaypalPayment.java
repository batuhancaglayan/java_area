package com.object.oriented.design.shopping.system.payment;

import com.object.oriented.design.shopping.system.model.User;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PaypalPayment implements Payment {

	private User user;

	@Override
	public boolean makePayment(double price) {
		return false;
	}
}
