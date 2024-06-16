package com.chess.engine.board;

import com.chess.engine.pieces.Piece;

public final class MajorMove extends Move {

	public MajorMove(final Board board, final Piece movedPiece, final int destination) {
		super(board, movedPiece, destination);
	}

	@Override
	public boolean isAttack() {
		return false;
	}

	@Override
	public boolean equals(final Object other) {
		return this == other || other instanceof MajorMove && super.equals(other);
	}
}
