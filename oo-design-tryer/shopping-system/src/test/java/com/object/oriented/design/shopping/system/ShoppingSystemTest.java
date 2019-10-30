package com.object.oriented.design.shopping.system;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.object.oriented.design.shopping.system.manager.UserManager;
import com.object.oriented.design.shopping.system.model.Account;
import com.object.oriented.design.shopping.system.model.Order;
import com.object.oriented.design.shopping.system.model.Product;
import com.object.oriented.design.shopping.system.model.ProductCategory;
import com.object.oriented.design.shopping.system.model.User;
import com.object.oriented.design.shopping.system.payment.CreditCardInformation;
import com.object.oriented.design.shopping.system.payment.PaymentType;
import com.object.oriented.design.shopping.system.storage.ProductStorage;
import com.object.oriented.design.shopping.system.storage.ShoppingCart;

public class ShoppingSystemTest {

	@InjectMocks
	private ShoppingSystem shoppingSystem;

	@Spy
	private UserManager userManager;

	@Spy
	private ProductStorage productStorage;

	private UUID tempUserId = UUID.randomUUID();

	private UUID tempProductId = UUID.randomUUID();

	@Before
	public void beforeClass() {
		MockitoAnnotations.initMocks(this);
		this.userManager.put(
				new User(tempUserId, "batuhan", new Account(null, new CreditCardInformation("batuhan", 111111, 11))));

		this.productStorage.put(new Product(tempProductId, "product1", 11, new ProductCategory("dale", "don dale")));
	}

	@Test
	public void getUserAccountTest() {
		User user = this.shoppingSystem.getUser(tempUserId);
		assertNotNull(user);
		assertThat(user.getId(), equalTo(this.tempUserId));
	}

	@Test
	public void addItemToCartTest() {
		this.shoppingSystem.addItemToCart(this.tempUserId, this.tempProductId);
		ShoppingCart shoppingCart = this.shoppingSystem.getShoppingCart(this.tempUserId);
		assertNotNull(shoppingCart);
		assertTrue(shoppingCart.hasItem());
	}

	@Test
	public void takeOrder() {
		this.shoppingSystem.addItemToCart(this.tempUserId, this.tempProductId);
		Order order = this.shoppingSystem.takeOrder(tempUserId, PaymentType.CREDIT);
		assertNotNull(order);
		assertThat(order.getItemList().get(0).getProductId(), equalTo(this.tempProductId));
	}
}
