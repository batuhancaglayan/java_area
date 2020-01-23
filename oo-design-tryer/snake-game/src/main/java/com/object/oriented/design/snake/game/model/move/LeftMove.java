package com.object.oriented.design.snake.game.model.move;

import java.awt.Point;

import com.object.oriented.design.snake.game.util.CellUtil;

public class LeftMove implements Move {

	@Override
	public Point move(int x, int y) {
		return CellUtil.generateLeftPoint(x, y);
	}
}

