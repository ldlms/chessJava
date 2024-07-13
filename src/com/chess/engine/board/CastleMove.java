package com.chess.engine.board;

import com.chess.engine.board.Board.Builder;
import com.chess.engine.pieces.Piece;
import com.chess.engine.pieces.Rook;

public abstract class CastleMove extends Move {
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

	@Override
	public boolean isCastlingMove() {
		return true;
	}

	@Override
	public Board execute() {
		final Builder builder = new Builder();
		for (final Piece piece : this.board.currentPlayer().getActivePiece()) {
			if (!this.movedPiece.equals(piece) && !this.castleRook.equals(piece)) {
				builder.setPiece(piece);
			}
		}
		for (final Piece piece : this.board.currentPlayer().getOpponent().getActivePiece()) {
			builder.setPiece(piece);
		}
		builder.setPiece(this.movedPiece.movePiece(this));
		builder.setPiece(new Rook(this.castleRook.getAlliance(), this.castleRookDestination));
		builder.setMoveMaker(this.board.currentPlayer().getOpponent().getAlliance());
		return builder.build();
	}

	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + this.castleRook.hashCode();
		result = prime * result + this.castleRookDestination;
		return result;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CastleMove)) {
			return false;
		}
		final CastleMove otherCastleMove = (CastleMove) other;
		return super.equals(otherCastleMove) && this.castleRook.equals(otherCastleMove.getCastleRook());
	}

	public Rook getCastleRook() {
		return this.castleRook;
	}

	public static final class KingSideCastleMove extends CastleMove {
		public KingSideCastleMove(final Board board, final Piece movedPiece, final int destination,
				final Rook castleRook, final int castleRookDestination, final int castleRookStart) {
			super(board, movedPiece, destination, castleRook, castleRookStart, castleRookDestination);
		}

		@Override
		public String toString() {
			return "0-0";
		}

		@Override
		public boolean equals(Object other) {
			return this == other || other instanceof KingSideCastleMove && super.equals(other);

		}
	}

	public static final class QueenSideCastleMove extends CastleMove {
		public QueenSideCastleMove(final Board board, final Piece movedPiece, final int destination,
				final Rook castleRook, final int castleRookDestination, final int castleRookStart) {
			super(board, movedPiece, destination, castleRook, castleRookStart, castleRookDestination);
		}

		@Override
		public String toString() {
			return "0-0-0";
		}

		@Override
		public boolean equals(Object other) {
			return this == other || other instanceof QueenSideCastleMove && super.equals(other);

		}
	}

}
