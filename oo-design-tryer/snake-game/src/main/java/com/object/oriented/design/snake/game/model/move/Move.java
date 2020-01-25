package com.object.oriented.design.snake.game.model.move;

public interface Move {

	public enum MoveType{
		UP,
		DOWN,
		RIGHT,
		LEFT
	}
	
	void move();
}
