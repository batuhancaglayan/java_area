package com.object.oriented.design.shopping.system.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.object.oriented.design.shopping.system.model.User;

public class UserManager {

	private Map<UUID, User> userMap;

	{
		this.userMap = new HashMap<>();
	}

	public void put(User user) {
		this.userMap.put(user.getId(), user);
	}

	public User get(UUID userId) {
		return this.userMap.containsKey(userId) ? this.userMap.get(userId) : null;
	}
}
