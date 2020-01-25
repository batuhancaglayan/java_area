package com.object.oriented.design.snake.game;

import java.util.Scanner;

import com.object.oriented.design.snake.game.manager.SnakeGameManager;
import com.object.oriented.design.snake.game.model.Board;
import com.object.oriented.design.snake.game.model.Snake;
import com.object.oriented.design.snake.game.model.move.Move.MoveType;

public class App {

	private static final int BOARDX = 6;

	private static final int BOARDY = 6;

	public static void main(String[] args) {

		SnakeGameManager snakeGameManager = new SnakeGameManager(new Snake(BOARDX / 2, BOARDY / 2),
				new Board(BOARDX, BOARDY));
		Scanner scnr = new Scanner(System.in);
		while (true) {
			String input = scnr.next();
			switch (input) {
			case "w":
				snakeGameManager.move(MoveType.UP);
				break;
			case "a":
				snakeGameManager.move(MoveType.LEFT);
				break;
			case "s":
				snakeGameManager.move(MoveType.DOWN);
				break;
			case "d":
				snakeGameManager.move(MoveType.RIGHT);
				break;
			default:
				break;
			}
		}

	}
}
