package com.chess.engine.board;

import com.chess.engine.pieces.Piece;

public final class PawnMove extends Move {

	public PawnMove(final Board board, final Piece movedPiece, final int destination) {
		super(board, movedPiece, destination);
	}

	@Override
	public boolean equals(final Object other) {
		return this == other || other instanceof PawnMove && super.equals(other);
	}

	@Override
	public String toString() {
		return BoardUtils.getPositionAtCoordinate(this.getDestinationCoordinate());
	}
}
