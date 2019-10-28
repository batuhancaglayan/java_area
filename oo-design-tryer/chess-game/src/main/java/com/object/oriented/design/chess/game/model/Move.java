package com.object.oriented.design.chess.game.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Move {

	private BoardUnit startUnit;

	private BoardUnit finishUnit;
}
