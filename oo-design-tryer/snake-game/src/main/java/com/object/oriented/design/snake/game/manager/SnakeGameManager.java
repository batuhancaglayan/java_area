package com.object.oriented.design.snake.game.manager;

import java.awt.Point;
import java.util.Map;

import com.object.oriented.design.snake.game.model.Board;
import com.object.oriented.design.snake.game.model.Cell;
import com.object.oriented.design.snake.game.model.Snake;
import com.object.oriented.design.snake.game.model.move.DownMove;
import com.object.oriented.design.snake.game.model.move.LeftMove;
import com.object.oriented.design.snake.game.model.move.Move;
import com.object.oriented.design.snake.game.model.move.Move.MoveType;
import com.object.oriented.design.snake.game.model.move.RightMove;
import com.object.oriented.design.snake.game.model.move.UpMove;
import com.object.oriented.design.snake.game.util.CellUtil;

public class SnakeGameManager {

	private Snake snake;

	private Board board;

	private static Map<MoveType, Move> moveMap;

	static {
		moveMap.put(MoveType.UP, new UpMove());
		moveMap.put(MoveType.DOWN, new DownMove());
		moveMap.put(MoveType.RIGHT, new RightMove());
		moveMap.put(MoveType.LEFT, new LeftMove());
	}
	
	public SnakeGameManager(int x, int y) {
		this.snake = new Snake();
		this.board = new Board(x, y);
		this.board.generateBoardItem();
		this.snake.addTop(CellUtil.generateCentralPoint(x, y));
	}
	
	public void move(MoveType moveType) {
		Point snakeHead = this.snake.getFirst();
		Point movePoint = moveMap.get(moveType).move((int) snakeHead.getX(), (int) snakeHead.getY());
		Cell moveCell = board.getCellByPosition((int) movePoint.getX(), (int) movePoint.getY());

		// todo: change here with factory pattern
		boolean generateNewItem = false;
		switch (moveCell.getCellType()) {
		case EMPTY:
			this.snake.addTop(movePoint);
			this.snake.removeLast();
			break;
		case FOOD:
			this.snake.grow(movePoint);
			break;
		case POISON:
			this.snake.addTop(movePoint);
			this.snake.removeLast();
			this.snake.removeLast();
			break;
		default:
			break;
		}
		
		if (generateNewItem) {
			moveCell.clearCell();
			this.board.generateBoardItem();
		}
	}
}
