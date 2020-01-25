package com.object.oriented.design.snake.game.model;

import java.awt.Point;
import java.util.Deque;
import java.util.LinkedList;

public class Snake {

	private Point oldTail = null;
	
	private Deque<Point> snake;

	{
		this.snake = new LinkedList<Point>();
	}
	
	public Snake(int x, int y) {
		this.addTop(new Point(x, y));
	}

	public Point getFirst() {
		return this.snake.getFirst();
	}

	public void addTop(Point point) {
		this.snake.addFirst(point);
	}
	
	public void addToTail(Point point) {
		this.snake.addLast(point);
	}

	public void removeLast() {
		this.oldTail = this.snake.removeLast();
	}

	public void moveToPoint(Point point) {
		this.addTop(point);
		this.removeLast();
	}
	
	public void grow() {
		this.addToTail(this.oldTail);
	}
}
