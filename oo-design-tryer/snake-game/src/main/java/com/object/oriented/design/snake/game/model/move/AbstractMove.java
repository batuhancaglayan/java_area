package com.object.oriented.design.snake.game.model.move;

import java.awt.Point;

import com.object.oriented.design.snake.game.factory.VisitCellStrategyFactory;
import com.object.oriented.design.snake.game.model.Board;
import com.object.oriented.design.snake.game.model.Cell;
import com.object.oriented.design.snake.game.model.Snake;

public abstract class AbstractMove implements Move {

	protected Snake snake;

	protected Board board;

	public AbstractMove(Snake snake, Board board) {
		this.snake = snake;
		this.board = board;
	}

	@Override
	public void move() {
		Point snakeHead = this.snake.getFirst();
		Point movePoint = this.getMovePoint((int) snakeHead.getX(), (int) snakeHead.getY());
		Cell moveCell = board.getCellByPosition((int) movePoint.getX(), (int) movePoint.getY());

		this.snake.moveToPoint(movePoint);
		boolean visitEatResult = VisitCellStrategyFactory.getEatCellStrategy(moveCell.getCellType()).visit(this.snake,
				moveCell.getPosition());
		if (visitEatResult) {
			board.generateBoardItem();
		}
	}

	protected abstract Point getMovePoint(int x, int y);
}
