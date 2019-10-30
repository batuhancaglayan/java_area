package com.object.oriented.design.shopping.system;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.object.oriented.design.shopping.system.manager.UserManager;
import com.object.oriented.design.shopping.system.model.CartItem;
import com.object.oriented.design.shopping.system.model.Order;
import com.object.oriented.design.shopping.system.model.Product;
import com.object.oriented.design.shopping.system.model.User;
import com.object.oriented.design.shopping.system.payment.PaymentType;
import com.object.oriented.design.shopping.system.storage.ProductStorage;
import com.object.oriented.design.shopping.system.storage.ShoppingCart;

public class ShoppingSystem {

	private UserManager userManager;

	private ProductStorage productStorage;

	{
		this.userManager = new UserManager();
		this.productStorage = new ProductStorage();
	}

	public List<Product> getProductList() {
		return this.productStorage.getAllProduct();
	}

	public Map<Product, Integer> getAvailableProducts() {
		return this.productStorage.getAvailableProducts();
	}

	public ShoppingCart getShoppingCart(UUID userId) {
		return this.getUser(userId).getCart();
	}

	public User getUser(UUID userId) {
		User user = this.userManager.get(userId);
		if (user == null) {
			// throw user not found exception
		}

		return user;
	}

	public void addItemToCart(UUID userId, UUID itemId) {
		this.addItemToCart(userId, itemId, 1);
	}

	public void addItemToCart(UUID userId, UUID itemId, int quantity) {
		if (!this.productStorage.hasStock(itemId)) {
			// throw out of stock exception
		}

		Product product = this.productStorage.get(itemId);
		ShoppingCart userCart = this.getShoppingCart(userId);
		userCart.add(new CartItem(product.getId(), product.getPrice(), quantity));
	}

	public void removeItemFromCart(UUID userId, UUID itemId) {
		ShoppingCart userCart = this.getShoppingCart(userId);
		userCart.removeAll(itemId);
	}

	public void decreaseItemFromCart(UUID userId, UUID itemId) {
		ShoppingCart userCart = this.getShoppingCart(userId);
		userCart.remove(itemId);
	}

	public Order takeOrder(UUID userId, PaymentType paymentType) {
		User user = this.getUser(userId);
		ShoppingCart userCart = this.getShoppingCart(userId);
		Order order = new Order(user, userCart.getAllItems());
		order.setPayment(paymentType.createPayment(user));
		boolean result = order.takeOrder();
		if (!result) {
			userCart.getAllItems().forEach(x-> {
				this.productStorage.increaseQuantity(x.getProductId());
			});
			
			return null;
		}
		
		userCart.clearCart();
		return order;
	}
}
