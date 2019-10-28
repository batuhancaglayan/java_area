package com.object.oriented.design.logistic.system.design.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import com.object.oriented.design.logistic.system.design.model.Item;
import com.object.oriented.design.logistic.system.design.model.Order;
import com.object.oriented.design.logistic.system.design.model.User;

import lombok.Getter;

@Getter
public class LogisticSystem {

	private List<Item> itemStock;

	private List<User> userList;

	private Map<UUID, Order> orderMap;

	public LogisticSystem() {
		this.itemStock = new ArrayList<>();
		this.userList = new ArrayList<>();
		this.orderMap = new HashMap<>();
	}

	public UUID addUser(User user) {
		this.userList.add(user);
		return user.getId();
	}

	public UUID takeOrder(Order order) {
		this.orderMap.put(order.getId(), order);
		return order.getId();
	}

	public UUID addItem(Item item) {
		this.itemStock.add(item);
		return item.getId();
	}

	public Order trackOrderByUserId(UUID userId) {
		for (Entry<UUID, Order> order : orderMap.entrySet()) {
			if (order.getValue().getSender().getId().equals(userId)) {
				return order.getValue();
			}
		}

		return null;
	}

	public Order trackOrderByOrder(UUID orderId) {
		return orderMap.containsKey(orderId) ? orderMap.get(orderId) : null;
	}
}
