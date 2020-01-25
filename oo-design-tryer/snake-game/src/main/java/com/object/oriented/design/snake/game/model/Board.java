package com.object.oriented.design.snake.game.model;

import java.awt.Point;

import com.object.oriented.design.snake.game.model.Cell.CellType;
import com.object.oriented.design.snake.game.util.CellUtil;

public class Board {

	private final int boardX;

	private final int boardY;

	private final Cell[][] boardArr;

	private Cell currentBoardItem = null;

	public Board(int x, int y) {
		this.boardX = x;
		this.boardY = y;
		this.boardArr = new Cell[x][y];
		this.init();
	}

	private void init() {
		for (int i = 0; i < boardX; i++) {
			for (int j = 0; j < boardY; j++) {
				boardArr[i][j] = new Cell(new Point(i, j), CellType.EMPTY);
			}
		}
		
		this.generateBoardItem();
	}

	public Cell getCellByPosition(int x, int y) {
		return this.boardArr[x][y];
	}

	public void generateBoardItem() {
		if (currentBoardItem != null) {
			currentBoardItem.setCellType(CellType.EMPTY);
		}
		
		Point point = CellUtil.generateRandomPoint(this.boardX, this.boardY);
		Cell cell = this.getCellByPosition((int) point.getX(), (int) point.getY());
		cell.setCellType(CellUtil.generateCellType());
		this.currentBoardItem = cell;
	}
}
