package com.custom.cache.implementation;

import org.junit.Test;

import com.custom.datastructure.linkedlist.LinkedList;

public class LinkedListTest {

	@Test
	public void linkedList() {

		LinkedList<Integer> lkl = new LinkedList<>();
		lkl.add(1);
		lkl.add(2);
		lkl.add(3);
		lkl.add(4);
		lkl.add(5);

		// lkl.remove(1);
		lkl.print();
		lkl.reverse();
		lkl.print();
	}
}
