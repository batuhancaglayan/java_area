package com.object.oriented.design.shopping.system.payment;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaypalInformation implements PaymentInformation {

	private UUID accountId;
}
