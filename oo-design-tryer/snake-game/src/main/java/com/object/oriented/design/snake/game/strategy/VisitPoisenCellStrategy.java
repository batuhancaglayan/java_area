package com.object.oriented.design.snake.game.strategy;

import java.awt.Point;

import com.object.oriented.design.snake.game.model.Snake;

public class VisitPoisenCellStrategy implements VisitCellStrategy {

	@Override
	public boolean visit(Snake snake, Point movePoint) {
		snake.removeLast();
		return true;
	}
}
