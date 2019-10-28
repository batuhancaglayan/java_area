package com.object.oriented.design.chess.game.manager;

import com.object.oriented.design.chess.game.model.Board;
import com.object.oriented.design.chess.game.model.BoardUnit;
import com.object.oriented.design.chess.game.model.ChessBoard;
import com.object.oriented.design.chess.game.model.GameStatus;
import com.object.oriented.design.chess.game.model.Move;
import com.object.oriented.design.chess.game.model.Piece;
import com.object.oriented.design.chess.game.model.Player;

public class ChessManager {

	private GameStatus gameStatus = GameStatus.STARTED;

	private Player[] playerArr;

	private Player currPlayer;

	private Board board = new ChessBoard();

	public GameStatus isGameEnd() {
		return this.gameStatus;
	}

	public void endGame() {
		this.gameStatus = GameStatus.FINISHED;
	}

	public boolean move(Player player, int startX, int startY, int endX, int endY) {
		return this.canMove(player,
				new Move(this.board.getBoardUnit(startX, startY), this.board.getBoardUnit(endX, endY)));
	}

	private boolean canMove(Player player, Move move) {

		if (!this.currPlayer.equals(player)) {
			return false;
		}

		return false;
	}
}
