package com.chess.engine.player;

import com.chess.engine.board.Board;
import com.chess.engine.board.Move;

public class MoveTransition {

	private final Board TransitionBoard;
	private final Move move;
	private final MoveStatus movestatus;

	public MoveTransition(final Board board, final Move move, final MoveStatus movestatus) {
		this.TransitionBoard = board;
		this.move = move;
		this.movestatus = movestatus;
	}

	public MoveStatus getMoveStatus() {
		return this.movestatus;
	}

	public Board getTransitionBoard() {
		return this.TransitionBoard;
	}

	public Move getMove() {
		return this.move;
	}
}
