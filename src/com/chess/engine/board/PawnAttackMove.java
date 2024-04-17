package com.chess.engine.board;

import com.chess.engine.pieces.Piece;

public class PawnAttackMove extends AttackMove {

	public PawnAttackMove(final Board board, final Piece movedPiece, final Piece attackedPiece, final int coordinate) {
		super(board, movedPiece, attackedPiece, coordinate);
	}
}
