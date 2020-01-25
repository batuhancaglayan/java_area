package com.object.oriented.design.snake.game.model.move;

import java.awt.Point;

import com.object.oriented.design.snake.game.model.Board;
import com.object.oriented.design.snake.game.model.Snake;
import com.object.oriented.design.snake.game.util.CellUtil;

public class UpMove extends AbstractMove {

	public UpMove(Snake snake, Board board) {
		super(snake, board);
	}

	@Override
	protected Point getMovePoint(int x, int y) {
		return CellUtil.generateUpPoint(x, y);
	}
}
