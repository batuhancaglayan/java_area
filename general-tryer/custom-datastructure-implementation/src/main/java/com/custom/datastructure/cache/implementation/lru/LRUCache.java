package com.custom.datastructure.cache.implementation.lru;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCache {

	private Map<Integer, Entry> hashmap;

	private Entry start, end;

	private int LRU_SIZE = 4;

	public LRUCache() {
		this.hashmap = new ConcurrentHashMap<>();
	}

	public int getEntry(int key) {
		if (hashmap.containsKey(key)) // Key Already Exist, just update the
		{
			Entry entry = hashmap.get(key);
			removeNode(entry);
			addAtTop(entry);
			return entry.value;
		}

		return -1;
	}

	public void putEntry(int key, int value) {
		if (hashmap.containsKey(key)) // Key Already Exist, just update the value and move it to top
		{
			Entry entry = hashmap.get(key);
			entry.value = value;
			removeNode(entry);
			addAtTop(entry);
		} else {
			Entry newnode = new Entry();
			newnode.left = null;
			newnode.right = null;
			newnode.value = value;
			newnode.key = key;
			if (hashmap.size() > LRU_SIZE) // We have reached maxium size so need to make room for new element.
			{
				hashmap.remove(end.key);
				removeNode(end);
				addAtTop(newnode);

			} else {
				addAtTop(newnode);
			}

			hashmap.put(key, newnode);
		}
	}

	public void addAtTop(Entry node) {
		node.right = start;
		node.left = null;
		if (start != null) {
			start.left = node;
		}
		
		start = node;
		if (end == null) {
			end = start;
		}
	}

	public void removeNode(Entry node) {

		if (node.left != null) {
			node.left.right = node.right;
		} else {
			start = node.right;
		}

		if (node.right != null) {
			node.right.left = node.left;
		} else {
			end = node.left;
		}
	}

	private class Entry {

		int value;

		int key;

		Entry left;

		Entry right;
	}
}
