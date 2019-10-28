package com.custom.datastructure.linkedlist;

public class LinkedList<T> {

	private Node<T> head;

	public void add(T value) {
		if (head == null) {
			head = new Node<T>(value);
			return;
		} else {

			Node<T> last = head;
			while (last.next != null) {
				last = last.next;
			}

			last.next = new Node<T>(value);
		}
	}

	public void remove(T value) {
		if (head == null || value == null) {
			return;
		}

		if (head.value == value) {
			head = head.next;
			return;
		}

		Node<T> relatedNode = head;
		while (relatedNode.next != null) {
			if (relatedNode.next.value == value) {
				relatedNode.next = relatedNode.next.next;
				relatedNode = null;
				break;
			}

			relatedNode = relatedNode.next;
		}
	}

	public void reverse() {
		if (head == null) {
			return;
		}

		Node<T> p1 = head;
		Node<T> p2;
		while (p1.next != null) {
			p2 = p1.next;
			p1.next = p2.next;
			p2.next = head;
			head = p2;
		}
	}

	public void print() {

		Node<T> currNode = head;
		while (currNode != null) {
			System.out.println(currNode.value);
			currNode = currNode.next;
		}
	}

	private class Node<T> {

		T value;
		Node<T> next;

		public Node(T value) {
			this(value, null);
		}

		public Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}
	}
}
