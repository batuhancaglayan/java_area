package com.object.oriented.design.shopping.system.model;

import java.util.UUID;

import com.object.oriented.design.shopping.system.storage.ShoppingCart;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class User {

	private @NonNull UUID id;

	private @NonNull String name;

	private @NonNull Account account;
	
	private ShoppingCart cart = new ShoppingCart();

	public void clearCart() {
		this.cart.clearCart();
	}
}
