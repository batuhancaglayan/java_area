package com.unit.test.tryer.unit.test.wihtout.spring.commandpattern;

import java.awt.Point;

public class MoveLeft implements Move {

	private Point point;

	public MoveLeft(Point point) {
		this.point = point;
	}

	public Point move() {
		return new Point((int) point.getX() - 1, (int) point.getY());
	}
}