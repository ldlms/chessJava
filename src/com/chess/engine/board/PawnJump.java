package com.chess.engine.board;

import com.chess.engine.pieces.Piece;

public class PawnJump extends Move {

	public PawnJump(final Board board, final Piece movedPiece, final int destination) {
		super(board, movedPiece, destination);
	}
}
