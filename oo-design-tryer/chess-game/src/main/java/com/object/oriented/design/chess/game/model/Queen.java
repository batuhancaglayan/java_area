package com.object.oriented.design.chess.game.model;

public class Queen extends Piece {

	public Queen(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public boolean canMove(Board board, BoardUnit start, BoardUnit end) {
		return false;
	}
}