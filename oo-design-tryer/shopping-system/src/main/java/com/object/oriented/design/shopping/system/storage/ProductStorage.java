package com.object.oriented.design.shopping.system.storage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.stream.Collectors;

import com.object.oriented.design.shopping.system.model.Product;

public class ProductStorage {

	private Map<UUID, Integer> quantityMap;

	private Map<UUID, Product> productMap;

	{
		this.quantityMap = new HashMap<>();
		this.productMap = new HashMap<>();
	}

	public void put(Product product) {
		if (!this.productMap.containsKey(product.getId())) {
			this.productMap.put(product.getId(), product);
		}

		this.increaseQuantity(product.getId());
	}

	public Product get(Product product) {
		return this.get(product.getId());
	}

	public Product get(UUID productId) {
		if (this.quantityMap.containsKey(productId)) {
			this.decreaseQuantity(productId);
			return this.productMap.get(productId).toBuilder().build();
		}

		return null;
	}

	public List<Product> getAllProduct() {
		return this.productMap.values().stream().collect(Collectors.toList());
	}

	public Map<Product, Integer> getAvailableProducts() {
		Map<Product, Integer> availableItemMap = new HashMap<>();
		for (Entry<UUID, Integer> quantityEntry : this.quantityMap.entrySet()) {
			availableItemMap.put(this.productMap.get(quantityEntry.getKey()), quantityEntry.getValue());
		}

		return availableItemMap;
	}

	public boolean hasStock(UUID productId) {
		return this.quantityMap.containsKey(productId);
	}

	public int getQuantityForProduct(UUID productId) {
		if (this.quantityMap.containsKey(productId)) {
			return this.quantityMap.get(productId);
		}

		return -1;
	}

	public void increaseQuantity(UUID productId) {		
		int quantity = 1;
		if (this.quantityMap.containsKey(productId)) {
			quantity = this.quantityMap.get(productId) + 1;
		}
		
		this.quantityMap.put(productId, quantity);
	}

	public void decreaseQuantity(UUID productId) {
		int quantity = this.quantityMap.get(productId);
		if (quantity <= 1) {
			this.quantityMap.remove(productId);
			return;
		}

		this.quantityMap.put(productId, quantity - 1);
	}
}
