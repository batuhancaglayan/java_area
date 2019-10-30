package com.object.oriented.design.shopping.system.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardInformation implements PaymentInformation {

	private String ownerName;

	private long cardNumber;

	private int cvsNumber;
}
