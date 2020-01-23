package com.object.oriented.design.snake.game.model;

import java.awt.Point;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Cell {

	private Point position;

	@Setter
	private CellType cellType;
	
	public void clearCell() {
		this.cellType = CellType.EMPTY;
	}

	public enum CellType {
		EMPTY, FOOD, POISON
	}
}
