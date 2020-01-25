package com.object.oriented.design.snake.game.manager;

import java.util.HashMap;
import java.util.Map;

import com.object.oriented.design.snake.game.model.Board;
import com.object.oriented.design.snake.game.model.Snake;
import com.object.oriented.design.snake.game.model.move.DownMove;
import com.object.oriented.design.snake.game.model.move.LeftMove;
import com.object.oriented.design.snake.game.model.move.Move;
import com.object.oriented.design.snake.game.model.move.Move.MoveType;
import com.object.oriented.design.snake.game.model.move.RightMove;
import com.object.oriented.design.snake.game.model.move.UpMove;

public class SnakeGameManager {

	private final Map<MoveType, Move> moveMap = new HashMap<>();

	public SnakeGameManager(Snake snake, Board board) {
		this.moveMap.put(MoveType.UP, new UpMove(snake, board));
		this.moveMap.put(MoveType.DOWN, new DownMove(snake, board));
		this.moveMap.put(MoveType.RIGHT, new RightMove(snake, board));
		this.moveMap.put(MoveType.LEFT, new LeftMove(snake, board));
	}

	public void move(MoveType moveType) {
		moveMap.get(moveType).move();
	}
}
