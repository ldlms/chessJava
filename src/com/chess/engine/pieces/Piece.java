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

	public abstract Collection<Move> calculateLegalMoves(final Board board);

	Piece(final PieceType pieceType, final int piecePosition, final Alliance pieceAlliance) {
		this.piecePosition = piecePosition;
		this.pieceAlliance = pieceAlliance;
		this.pieceType = pieceType;
		this.isFirstMove = false;
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
		},

		KNIGHT("N") {

			public boolean isKing() {
				return false;
			}
		},
		BISHOP("B") {

			public boolean isKing() {
				return false;
			}
		},
		ROOK("R") {

			public boolean isKing() {
				return false;
			}
		},
		QUEEN("Q") {

			public boolean isKing() {
				return false;
			}
		},
		KING("K") {

			public boolean isKing() {
				return true;
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
	}
}
