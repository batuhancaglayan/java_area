package com.object.oriented.design.chess.game.model;

public class Piskopos extends Piece {

	public Piskopos(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public boolean canMove(Board board, BoardUnit start, BoardUnit end) {
		return false;
	}
}
