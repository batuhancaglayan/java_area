package com.object.oriented.design.chess.game.model;

public class Rook extends Piece {

	public Rook(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public boolean canMove(Board board, BoardUnit start, BoardUnit end) {
		return false;
	}
}