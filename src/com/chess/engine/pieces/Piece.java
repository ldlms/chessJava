package com.chess.engine.pieces;

import java.util.Collection;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;

public abstract class Piece {

	protected final int piecePosition;
	protected final Alliance pieceAlliance;
	protected final boolean isFirstMove;
	protected final PieceType pieceType;
	private final int cachedHashCode;

	public abstract Collection<Move> calculateLegalMoves(final Board board);

	Piece(final PieceType pieceType, final int piecePosition, final Alliance pieceAlliance) {
		this.piecePosition = piecePosition;
		this.pieceAlliance = pieceAlliance;
		this.pieceType = pieceType;
		this.isFirstMove = false;
		this.cachedHashCode = computedHashCode();
	}

	private int computedHashCode() {
		int result = pieceType.hashCode();
		result = 31 + result + pieceAlliance.hashCode();
		result = 31 + result + piecePosition;
		result = 31 + result + (isFirstMove ? 1 : 0);
		return result;
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Piece)) {
			return false;
		}
		final Piece otherPiece = (Piece) other;
		return piecePosition == otherPiece.getPiecePosition() && pieceType == otherPiece.getPieceType()
				&& pieceAlliance == otherPiece.getAlliance() && isFirstMove == otherPiece.isFirstMove();
	}

	@Override
	public int hashCode() {
		return this.cachedHashCode;
	}

	public int getPiecePosition() {
		return this.piecePosition;
	}

	public Alliance getAlliance() {
		return this.pieceAlliance;
	}

	public boolean isFirstMove() {
		return this.isFirstMove;
	}

	public PieceType getPieceType() {
		return this.pieceType;
	}

	public abstract Piece movePiece(Move move);

	public enum PieceType {
		PAWN("P") {

			public boolean isKing() {
				return false;
			}

			@Override
			public boolean isRook() {
				// TODO Auto-generated method stub
				return false;
			}
		},

		KNIGHT("N") {

			public boolean isKing() {
				return false;
			}

			@Override
			public boolean isRook() {
				// TODO Auto-generated method stub
				return false;
			}
		},
		BISHOP("B") {

			public boolean isKing() {
				return false;
			}

			@Override
			public boolean isRook() {
				// TODO Auto-generated method stub
				return false;
			}
		},
		ROOK("R") {

			public boolean isKing() {
				return false;
			}

			@Override
			public boolean isRook() {
				// TODO Auto-generated method stub
				return true;
			}
		},
		QUEEN("Q") {

			public boolean isKing() {
				return false;
			}

			@Override
			public boolean isRook() {
				// TODO Auto-generated method stub
				return false;
			}
		},
		KING("K") {

			public boolean isKing() {
				return true;
			}

			@Override
			public boolean isRook() {
				// TODO Auto-generated method stub
				return false;
			}
		};

		final String pieceName;

		PieceType(final String pieceName) {
			this.pieceName = pieceName;
		}

		@Override
		public String toString() {
			return this.pieceName;
		}

		public abstract boolean isKing();

		public abstract boolean isRook();
	}
}
