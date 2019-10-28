package com.unit.test.tryer.unit.test.wihtout.spring.commandpattern;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class DenemeContext {

	private Map<Move.MoveType, Move> moveMap;

	public DenemeContext(final Point point) {

		this.moveMap = new HashMap<Move.MoveType, Move>() {
			private static final long serialVersionUID = 1L;
			{
				put(Move.MoveType.UP, new MoveUp(point));
				put(Move.MoveType.DOWN, new MoveDown(point));
				put(Move.MoveType.RIGHT, new MoveRight(point));
				put(Move.MoveType.LEFT, new MoveLeft(point));
			}
		};
	}

	public Point getNextPoint(Move.MoveType moveType) {
		return moveMap.get(moveType).move();
	}
}
