package com.custom.datastructure.cache.implementation.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUWithBuiltIn<K, V> {

	private Map<K, V> cache;

	public LRUWithBuiltIn(int cacheSize) {
		this.cache = new LinkedHashMap<K, V>(16, 0.75f, true) {

			private static final long serialVersionUID = 4610126946021494632L;

			@Override
			protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
				return size() > cacheSize;
			}
		};
	}

	public V get(K key) {
		return this.cache.get(key);
	}

	public void set(K key, V value) {
		this.cache.put(key, value);
	}
}
