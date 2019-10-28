package com.object.oriented.design.vending.machine.storage;

import java.util.HashMap;
import java.util.Map;

public class QantityStorege<T> {

	private Map<T, Integer> storege;

	{
		this.storege = new HashMap<T, Integer>();
	}
	
	public boolean hasItem(T key) {
		return this.storege.containsKey(key);
	}

	public void increaseQantity(T key) {
		if (this.hasItem(key)) {
			this.storege.put(key, this.storege.get(key) + 1);
		} else {
			this.storege.put(key, 1);
		}
	}

	public void decreaseQantity(T key) {
		if (this.hasItem(key)) {
			int quantity = this.storege.get(key);
			if (quantity <= 1) {
				this.storege.remove(key);
				return;
			}

			this.storege.put(key, this.storege.get(key) - 1);
		}
	}

	public T getItem(T key) {
		if (!this.hasItem(key)) {
			return null;
		}

		this.decreaseQantity(key);
		return key;
	}
}
