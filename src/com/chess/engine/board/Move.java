package com.chess.engine.board;

import com.chess.engine.board.Board.Builder;
import com.chess.engine.pieces.Piece;

public abstract class Move {

	final Board board;
	final Piece movedPiece;
	final int destination;

	public static final Move NULL_MOVE = new NullMove();

	public Move(final Board board, final Piece movedPiece, final int destination) {
		this.board = board;
		this.movedPiece = movedPiece;
		this.destination = destination;
	}

	public int getDestinationCoordinate() {
		return this.destination;
	}

	public Piece getMovedPiece() {
		return this.movedPiece;
	}

	public int getCurrentCoordinate() {
		return this.getMovedPiece().getPiecePosition();
	}

	public Board execute() {
		final Builder builder = new Builder();
		for (final Piece piece : this.board.currentPlayer().getActivePiece()) {
			if (!this.movedPiece.equals(piece)) {
				builder.setPiece(piece);
			}
		}
		for (final Piece piece : this.board.currentPlayer().getOpponent().getActivePiece()) {
			builder.setPiece(piece);
		}
		builder.setPiece(this.movedPiece.movePiece(this));
		builder.setMoveMaker(this.board.currentPlayer().getOpponent().getAlliance());
		return builder.build();
	}
}
