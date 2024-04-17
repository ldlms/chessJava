package com.chess.engine.board;

import com.chess.engine.pieces.Piece;

public class PawnEnPassant extends PawnAttackMove {

	public PawnEnPassant(final Board board, final Piece movedPiece, final Piece attackedPiece, final int coordinate) {
		super(board, attackedPiece, movedPiece, coordinate);
	}
}
