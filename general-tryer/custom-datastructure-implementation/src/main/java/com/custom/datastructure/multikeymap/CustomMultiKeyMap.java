package com.custom.datastructure.multikeymap;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class CustomMultiKeyMap<K1, K2, V> {

	private Map<MultiKeyObject, V> store;

	private Comparator<Object> keyComparator;

	private Comparator<Object> partialKey;

	{
		this.store = new ConcurrentHashMap<>();
		this.keyComparator = new Comparator<Object>() {
			@Override
			public int compare(Object obj1, Object obj2) {
				MultiKeyObject keyValue1 = (MultiKeyObject) obj1;
				MultiKeyObject keyValue2 = (MultiKeyObject) obj2;
				return keyValue1.getKey1().equals(keyValue2.getKey1())
						&& keyValue1.getKey2().equals(keyValue2.getKey2()) ? 1 : 0;
			}
		};

		this.partialKey = new Comparator<Object>() {
			@Override
			public int compare(Object keyValue1, Object keyValue2) {
				return keyValue1.equals(keyValue2) ? 1 : 0;
			}
		};
	}

	@Getter
	@AllArgsConstructor
	private class MultiKeyObject {
		private K1 key1;

		private K2 key2;

		private Comparator<Object> comparator;

		@Override
		public int hashCode() {
			return this.key1.hashCode() * this.key2.hashCode();
		}
		
		@Override
		public boolean equals(Object obj) {
			return this.comparator.compare(this, obj) == 1;
		}
	}

	public void put(K1 key1, K2 key2, V value) {
		this.store.put(new MultiKeyObject(key1, key2, this.keyComparator), value);
	}

	public V get(K1 key1, K2 key2) {
		if (this.containsKey(key1, key2)) {
			return this.store.get(new MultiKeyObject(key1, key2, this.keyComparator));
		}

		return null;
	}

	public List<V> getK1ValueList(K1 key1) {
		if (this.store.containsKey(new MultiKeyObject(key1, null, this.partialKey))) {
			Object a = this.store.get(new MultiKeyObject(key1, null, this.partialKey));
			System.out.println("a");
		}

		return null;
	}

	public boolean containsKey(K1 key1, K2 key2) {
		return this.store.containsKey(new MultiKeyObject(key1, key2, this.keyComparator));
	}
}
