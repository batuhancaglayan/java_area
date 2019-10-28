package com.object.oriented.design.chess.game.model;

public abstract class Piece {

	private boolean isActive = true;

	private boolean isWhite;

	public Piece(boolean isWhite) {
		this.isWhite = isWhite;
	}

	public boolean isActive() {
		return this.isActive;
	}

	public boolean isWhite() {
		return this.isWhite;
	}

	public void disablePiece() {
		this.isActive = false;
	}

	public abstract boolean canMove(Board board, BoardUnit start, BoardUnit end);
}
