package com.chess.engine.board;

import com.chess.engine.pieces.Piece;

public final class PawnMove extends Move {

	public PawnMove(final Board board, final Piece movedPiece, final int destination) {
		super(board, movedPiece, destination);
	}
}
