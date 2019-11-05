package com.design.pattern.flyweight.pattern;

import java.awt.Color;

import com.design.pattern.flyweight.pattern.frame.Forest;

public class App {

	private static int CANVAS_SIZE = 500;

	private static int TREES_TO_DRAW = 1000000;

	private static int TREE_TYPES = 2;

	public static void main(String[] args) {

		Forest forest = new Forest();
		for (int i = 0; i < Math.floor(TREES_TO_DRAW / TREE_TYPES); i++) {
			forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE), "Summer Oak", Color.GREEN,
					"Oak texture stub" + i);
			forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE), "Autumn Oak", Color.ORANGE,
					"Autumn Oak texture stub" + i);
		}
	}

	private static int random(int min, int max) {
		return min + (int) (Math.random() * ((max - min) + 1));
	}
}
