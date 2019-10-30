package com.object.oriented.design.shopping.system.model;

import java.util.List;

import com.object.oriented.design.shopping.system.payment.Payment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class Order {

	private final User user;

	private final List<CartItem> itemList;

	private OrderStatus status = OrderStatus.NOTPAYED;

	@Setter
	private Payment payment;

	public boolean takeOrder() {

		Double sum = itemList.stream().mapToDouble(x -> x.getUnitPrice() * x.getQuantity()).reduce(0, Double::sum);
		boolean result = this.payment.makePayment(sum);
		if (result) {
			this.status = OrderStatus.PROCESSING;
		}

		return result;
	}

	public enum OrderStatus {
		NOTPAYED, PROCESSING, SHIPPED
	}
}
