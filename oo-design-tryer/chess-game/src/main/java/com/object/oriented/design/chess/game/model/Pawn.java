package com.object.oriented.design.chess.game.model;

public class Pawn extends Piece {

	public Pawn(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public boolean canMove(Board board, BoardUnit start, BoardUnit end) {
		return false;
	}
}
