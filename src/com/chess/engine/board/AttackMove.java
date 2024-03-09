package com.chess.engine.board;

import com.chess.engine.pieces.Piece;

public final class AttackMove extends Move {

	final Piece attackedPiece;

	public AttackMove(final Board board, final Piece movedPiece, final Piece attackedPiece, final int coordinate) {
		super(board, movedPiece, coordinate);
		this.attackedPiece = attackedPiece;
	}
}
