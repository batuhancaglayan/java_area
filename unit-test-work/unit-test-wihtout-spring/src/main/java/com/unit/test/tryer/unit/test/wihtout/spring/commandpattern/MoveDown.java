package com.unit.test.tryer.unit.test.wihtout.spring.commandpattern;

import java.awt.Point;

public class MoveDown implements Move {
	
	private Point point;

	public MoveDown(Point point) {
		this.point = point;
	}

	public Point move() {
		return new Point((int) point.getX(), (int) point.getY() + 1);
	}
}