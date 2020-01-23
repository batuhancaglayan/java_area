package com.object.oriented.design.snake.game.model;

import java.awt.Point;

import com.object.oriented.design.snake.game.util.CellUtil;

public class Board {

	private final int boardX;

	private final int boardY;

	private final Cell[][] boardArr;

	public Board(int x, int y) {
		this.boardX = x;
		this.boardY = y;
		this.boardArr = new Cell[x][y];
	}

	public Cell getCellByPosition(int x, int y) {
		// todo: need to handle index out of band.
		return this.boardArr[x][y];
	}

	public void generateBoardItem() {
		Point point = CellUtil.generateRandomPoint(this.boardX, this.boardY);
		Cell cell = this.getCellByPosition((int) point.getX(), (int) point.getY());
		cell.setCellType(CellUtil.generateCellType());
	}
}
