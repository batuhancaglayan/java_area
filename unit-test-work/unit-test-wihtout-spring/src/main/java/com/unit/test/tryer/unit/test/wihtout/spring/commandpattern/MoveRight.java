package com.unit.test.tryer.unit.test.wihtout.spring.commandpattern;

import java.awt.Point;

public class MoveRight implements Move {

	private Point point;

	public MoveRight(Point point) {
		this.point = point;
	}

	public Point move() {
		return new Point((int) point.getX() + 1, (int) point.getY());
	}
}