package com.object.oriented.design.snake.game.util;

import java.awt.Point;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.object.oriented.design.snake.game.model.Cell.CellType;

public final class CellUtil {

	public static Point generateUpPoint(int x, int y) {
		return new Point(x, y - 1);
	}

	public static Point generateDownPoint(int x, int y) {
		return new Point(x, y + 1);
	}

	public static Point generateRightPoint(int x, int y) {
		return new Point(x + 1, y);
	}

	public static Point generateLeftPoint(int x, int y) {
		return new Point(x - 1, y);
	}

	public static Point generateCentralPoint(int x, int y) {
		return new Point(x / 2, y / 2);
	}

	public static Point generateRandomPoint(int x, int y) {
		return new Point(ThreadLocalRandom.current().nextInt(1, x) - 1, ThreadLocalRandom.current().nextInt(1, y) - 1);
	}

	public static CellType generateCellType() {
		float chance = new Random().nextFloat();
		CellType cellType = CellType.FOOD;
		if (chance <= 0.25f) {
			cellType = CellType.POISON;
		}

		return cellType;
	}
}
