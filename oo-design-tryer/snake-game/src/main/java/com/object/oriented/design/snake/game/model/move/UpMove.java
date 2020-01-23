package com.object.oriented.design.snake.game.model.move;

import java.awt.Point;

import com.object.oriented.design.snake.game.util.CellUtil;

public class UpMove implements Move {

	@Override
	public Point move(int x, int y) {
		return CellUtil.generateUpPoint(x, y);
	}
}
