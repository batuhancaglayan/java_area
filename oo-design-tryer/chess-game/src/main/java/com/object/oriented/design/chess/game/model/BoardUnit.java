package com.object.oriented.design.chess.game.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardUnit {

	private Piece piece;

	private int xPosition;

	private int yPoistion;
}
