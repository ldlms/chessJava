package com.chess.engine.board;

import com.chess.engine.pieces.Piece;
import com.chess.engine.pieces.Rook;

abstract class CastleMove extends Move {
	protected final Rook castleRook;
	protected final int castleRookStart;
	protected final int castleRookDestination;

	public CastleMove(final Board board, final Piece movedPiece, final int destination, final Rook castleRook,
			final int castleRookDestination, final int castleRookStart) {
		super(board, movedPiece, destination);
		this.castleRook = castleRook;
		this.castleRookDestination = castleRookDestination;
		this.castleRookStart = castleRookStart;
	}

	public static final class KingSideCastleMove extends CastleMove {
		public KingSideCastleMove(final Board board, final Piece movedPiece, final int destination,
				final Rook castleRook, final int castleRookDestination, final int castleRookStart) {
			super(board, movedPiece, destination, castleRook, castleRookStart, castleRookDestination);
		}
	}

	public static final class QueenSideCastleMove extends CastleMove {
		public QueenSideCastleMove(final Board board, final Piece movedPiece, final int destination,
				final Rook castleRook, final int castleRookDestination, final int castleRookStart) {
			super(board, movedPiece, destination, castleRook, castleRookStart, castleRookDestination);
		}
	}

}
