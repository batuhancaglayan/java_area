package com.custom.datastructure.stack.impl;

import java.util.Optional;
import java.util.Stack;

public class MaxStack<T extends Comparable<T>> extends Stack<T> {

	private static final long serialVersionUID = -3235570841225415731L;

	private Stack<T> maxStack;
	
	private T currMax;

	public MaxStack() {
		this.maxStack = new Stack<>();
	}

	@Override
	public T pop() {
		if (this.empty()) {
			return null;
		}

		this.maxStack.pop();
		return this.pop();
	}

	@Override
	public T push(T item) {

		if (maxStack.empty()) {
			currMax = item;
			maxStack.push(item);
		} else {
			maxStack.push(max(currMax, item));
		}

		return super.push(item);
	}

	public Optional<T> max() {
		return this.maxStack.isEmpty() ? Optional.empty() : Optional.of(this.maxStack.peek());
	}

	private T max(T a, T b) {
		return a.compareTo(b) > 0 ? a : b;
	}
}
