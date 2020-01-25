package com.object.oriented.design.snake.game.model.move;

import java.awt.Point;

import com.object.oriented.design.snake.game.model.Board;
import com.object.oriented.design.snake.game.model.Snake;
import com.object.oriented.design.snake.game.util.CellUtil;

public class LeftMove extends AbstractMove {

	public LeftMove(Snake snake, Board board) {
		super(snake, board);
	}

	@Override
	protected Point getMovePoint(int x, int y) {
		return CellUtil.generateLeftPoint(x, y);
	}
}

