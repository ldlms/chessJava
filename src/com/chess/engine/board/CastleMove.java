package com.chess.engine.board;

import com.chess.engine.pieces.Piece;

abstract class CastleMove extends Move {
	public CastleMove(final Board board, final Piece movedPiece, final int destination) {
		super(board, movedPiece, destination);
	}

	public static final class KingSideCastleMove extends CastleMove {
		public KingSideCastleMove(final Board board, final Piece movedPiece, final int destination) {
			super(board, movedPiece, destination);
		}
	}

	public static final class QueenSideCastleMove extends CastleMove {
		public QueenSideCastleMove(final Board board, final Piece movedPiece, final int destination) {
			super(board, movedPiece, destination);
		}
	}

}
