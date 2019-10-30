package com.object.oriented.design.shopping.system.storage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import com.object.oriented.design.shopping.system.model.CartItem;

public class ShoppingCart {

	private Map<UUID, CartItem> cartMap;

	{
		this.cartMap = new HashMap<>();
	}

	public CartItem get(UUID itemId) {
		return this.contains(itemId) ? this.cartMap.get(itemId) : null;
	}

	public List<CartItem> getAllItems() {
		return this.cartMap.values().stream().collect(Collectors.toList());
	}

	public boolean contains(UUID itemId) {
		return this.cartMap.containsKey(itemId);
	}
	
	public boolean hasItem() {
		return !this.cartMap.isEmpty();
	}

	public void add(CartItem item) {
		if (this.cartMap.containsKey(item.getProductId())) {
			CartItem cartItem = this.cartMap.get(item.getProductId());
			cartItem.increaseQuantity();
			return;
		}

		this.cartMap.put(item.getProductId(), item);
	}

	public void remove(CartItem item) {
		this.remove(item.getProductId());
	}

	public void remove(UUID itemId) {
		if (this.cartMap.containsKey(itemId)) {
			CartItem cartItem = this.cartMap.get(itemId);
			int quantity = cartItem.decreaseQuantity();
			if (quantity <= 0) {
				this.removeAll(itemId);
			}

			return;
		}
	}

	public void removeAll(UUID itemId) {
		this.cartMap.remove(itemId);
	}

	public void clearCart() {
		this.cartMap.clear();
	}
}
