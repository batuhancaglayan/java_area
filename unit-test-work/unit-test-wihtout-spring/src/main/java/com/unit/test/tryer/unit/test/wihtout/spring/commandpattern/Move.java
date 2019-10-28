package com.unit.test.tryer.unit.test.wihtout.spring.commandpattern;

import java.awt.Point;

public interface Move {

	public enum MoveType {
		UP, DOWN, RIGHT, LEFT;
	}

	Point move();
}
