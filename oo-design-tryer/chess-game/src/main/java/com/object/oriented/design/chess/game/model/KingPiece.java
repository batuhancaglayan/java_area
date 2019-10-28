package com.object.oriented.design.chess.game.model;

public class KingPiece extends Piece {

	public KingPiece(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public boolean canMove(Board board, BoardUnit start, BoardUnit end) {
		return false;
	}
}
