package com.object.oriented.design.logistic.system.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.object.oriented.design.logistic.system.design.manager.LogisticSystem;
import com.object.oriented.design.logistic.system.design.model.Item;
import com.object.oriented.design.logistic.system.design.model.Location;
import com.object.oriented.design.logistic.system.design.model.Order;
import com.object.oriented.design.logistic.system.design.model.User;

public class App {
	public static void main(String[] args) {
		LogisticSystem logisticSystem = new LogisticSystem();
		List<User> userList = new ArrayList<>();
		List<Item> itemList = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			User user = new User("batuhan1", new Location(i, i));
			Item item = new Item("item" + i, i);
			userList.add(user);
			itemList.add(item);
			logisticSystem.addItem(item);
			logisticSystem.addUser(user);
		}

		Order order1 = new Order(userList.get(0), new Location(10, 10),
				Arrays.asList(itemList.get(0), itemList.get(1)));
		logisticSystem.takeOrder(order1);

		Order orderedchck1 = logisticSystem.trackOrderByOrder(order1.getId());
		Order orderedchck2 = logisticSystem.trackOrderByUserId(userList.get(0).getId());

		System.out.println("aq");
	}
}
