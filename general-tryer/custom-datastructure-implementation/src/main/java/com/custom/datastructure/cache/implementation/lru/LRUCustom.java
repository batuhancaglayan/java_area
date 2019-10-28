package com.custom.datastructure.cache.implementation.lru;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class LRUCustom {

	private Map<Integer, Node> cache;

	private Node start, end;

	private int size;

	public LRUCustom(int size) {
		this.size = size;
		this.cache = new ConcurrentHashMap<>();
	}

	public void put(int key, Object value) {
		if (this.cache.containsKey(key)) {
			Node currentNode = this.cache.get(key);
			currentNode.value = value;
			this.removeNode(currentNode);
			this.addToTop(currentNode);
			// update position of node
		} else {

			Node newNode = new Node(key, value);
			if (cache.size() >= this.size) {
				this.cache.remove(end.key);
				this.removeNode(end);
			}

			this.addToTop(newNode);
			this.cache.put(key, newNode);

			// add to cache
			// add to start
			// size check if over remove end
		}
	}

	public void remove(int key) {
		// remove from cache
		// remove item manage links
	}

	public Object get() {
		// get node value
		return null;
	}

	public void display() {
		if (this.start != null) {
			this.printNoteRights(start);
		}
	}

	private void printNoteRights(Node node) {
		System.out.println(node.key);
		if (node.right != null) {
			this.printNoteRights(node.right);
		}
	}

	private void addToTop(Node node) {
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

	private void removeNode(Node node) {
		if (node.left == null) {
			start = node.right;
		} else {
			node.left.right = node.right;
		}

		if (node.right == null) {
			end = node.left;
		} else {
			node.right.left = node.left;
		}

//		if (node.left != null) {
//			node.left.right = node.right;
//		} else {
//			start = node.right;
//		}
//
//		if (node.right != null) {
//			node.right.left = node.left;
//		} else {
//			end = node.left;
//		}
	}

	@RequiredArgsConstructor
	private class Node {

		@NonNull
		int key;

		@NonNull
		Object value;

		Node left;

		Node right;
	}
}
