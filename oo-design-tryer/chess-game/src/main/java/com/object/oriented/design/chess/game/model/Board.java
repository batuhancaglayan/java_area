package com.object.oriented.design.chess.game.model;

public abstract class Board {

	private int xLength;

	private int yLength;

	private final BoardUnit[][] spotArr;

	public Board(int xLength, int yLength) {
		this.xLength = xLength;
		this.yLength = yLength;
		this.spotArr = new BoardUnit[xLength][yLength];
	}

	public BoardUnit getBoardUnit(int x, int y) {
		if (x < 0 || y < 0 || x >= this.xLength || y >= yLength) {
			throw new RuntimeException("Index out of bound");
		}

		return this.spotArr[x][y];
	}

	protected abstract void fillBoard();
}
