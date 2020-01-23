package com.object.oriented.design.snake.game.model;

import java.awt.Point;
import java.util.Deque;
import java.util.LinkedList;

public class Snake {

	private Deque<Point> snake;

	{
		this.snake = new LinkedList<Point>();
	}

	public Point getFirst() {
		return this.snake.getFirst();
	}

	public void addTop(Point point) {
		this.snake.addFirst(point);
	}

	public void removeLast() {
		this.snake.removeLast();
	}

	public void grow(Point point) {
		this.addTop(point);
	}
}
