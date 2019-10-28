package com.object.oriented.design.chess.game.model;

public class Knight extends Piece {

	public Knight(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public boolean canMove(Board board, BoardUnit start, BoardUnit end) {

		if (end.getPiece().isWhite() == this.isWhite()) {
			return false;
		}
		
		return false;
	}
}