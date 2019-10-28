package com.custom.datastructure.cache.implementation.lru;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRUWithDeque {

	private Deque<Integer> deque;

	private Map<Integer, String> cache;

	private int size;

	public LRUWithDeque(int size) {
		this.size = size;
		this.deque = new LinkedList<>();
		this.cache = new ConcurrentHashMap<>();
	}

	public void put(int key, String value) {
		if (this.cache.containsKey(key)) {
			this.deque.remove(key);
		} else {
			if (this.deque.size() >= this.size) {
				this.deque.removeLast();
			}
		}

		this.cache.put(key, value);
		this.deque.addFirst(key);
	}

	public String get(int key) {
		if (this.cache.containsKey(key)) {
			this.deque.remove(key);
			this.deque.addFirst(key);
			return this.cache.get(key);
		}

		return null;
	}

	public void remove(int key) {
		this.cache.remove(key);
		this.deque.remove(key);
	}

	public void display() {
		Iterator<Integer> itr = this.deque.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
