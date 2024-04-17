package com.chess.engine.board;

import com.chess.engine.pieces.Piece;

public class NullMove extends Move {

	public NullMove(final Board board, final Piece movedPiece, final int destination) {
		super(board, movedPiece, destination);
	}
}
