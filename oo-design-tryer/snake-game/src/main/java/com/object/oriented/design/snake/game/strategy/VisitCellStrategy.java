package com.object.oriented.design.snake.game.strategy;

import java.awt.Point;

import com.object.oriented.design.snake.game.model.Snake;

public interface VisitCellStrategy {

	boolean visit(Snake snake, Point movePoint);
}
