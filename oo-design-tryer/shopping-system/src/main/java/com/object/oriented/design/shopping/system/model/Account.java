package com.object.oriented.design.shopping.system.model;

import com.object.oriented.design.shopping.system.payment.CreditCardInformation;
import com.object.oriented.design.shopping.system.payment.PaypalInformation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Account {

	private PaypalInformation paypalInformation;

	private CreditCardInformation creditCardInformation;
}
