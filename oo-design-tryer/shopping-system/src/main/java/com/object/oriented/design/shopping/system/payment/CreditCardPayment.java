package com.object.oriented.design.shopping.system.payment;

import com.object.oriented.design.shopping.system.model.User;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreditCardPayment implements Payment {

	private User user;

	@Override
	public boolean makePayment(double price) {
		return price < 20;
	}
}
