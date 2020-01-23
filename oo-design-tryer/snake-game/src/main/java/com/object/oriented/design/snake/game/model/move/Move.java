package com.object.oriented.design.snake.game.model.move;

import java.awt.Point;

public interface Move {

	public enum MoveType{
		UP,
		DOWN,
		RIGHT,
		LEFT
	}
	
	Point move(int x, int y);
}
