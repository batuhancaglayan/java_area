package com.object.oriented.design.shopping.system.payment;

import com.object.oriented.design.shopping.system.model.User;

public enum PaymentType {

	CREDIT {
		@Override
		public Payment createPayment(User user) {
			return new CreditCardPayment(user);
		}
	},
	PAYPAL {
		@Override
		public Payment createPayment(User user) {
			return new PaypalPayment(user);
		}
	};

	public abstract Payment createPayment(User user);
}
