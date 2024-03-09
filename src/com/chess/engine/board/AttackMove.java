package com.chess.engine.board;

import com.chess.engine.pieces.Piece;

public final class AttackMove extends Move {

	public AttackMove(final Board board, final Piece movedPiece, final int coordinate) {
		super(board, movedPiece, coordinate);
	}
}
