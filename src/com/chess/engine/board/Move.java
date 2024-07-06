package com.chess.engine.board;

import com.chess.engine.board.Board.Builder;
import com.chess.engine.pieces.Piece;

public abstract class Move {

	protected final Board board;
	protected final Piece movedPiece;
	protected final int destination;
	protected final boolean isFirstMove;

	public static final Move NULL_MOVE = new NullMove();

	public Move(final Board board, final Piece movedPiece, final int destination) {
		this.board = board;
		this.movedPiece = movedPiece;
		this.destination = destination;
		this.isFirstMove = movedPiece.isFirstMove();
	}

	public Move(final Board board, final int destination) {
		this.board = board;
		this.destination = destination;
		this.movedPiece = null;
		this.isFirstMove = false;
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

	public boolean isAttack() {
		return false;
	}

	public boolean isCastlingMove() {
		return false;
	}

	public Piece getAttackedPiece() {
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime + result + this.destination;
		result = prime + result + this.movedPiece.hashCode();
		result = prime * result + this.movedPiece.getPiecePosition();
		return result;
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Move)) {
			return false;
		}
		final Move otherMove = (Move) other;
		return getCurrentCoordinate() == otherMove.getCurrentCoordinate()
				&& getDestinationCoordinate() == otherMove.getDestinationCoordinate()
				&& getMovedPiece().equals(otherMove.getMovedPiece());
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

	public static class MoveFactory {

		private MoveFactory() {
			throw new RuntimeException("not instanciable");
		}

		public static Move createMove(final Board board, final int currentCoordinate, final int destinationCoordinate) {
			for (final Move move : board.getAllLegalMoves()) {
				if (move.getCurrentCoordinate() == currentCoordinate
						&& move.getDestinationCoordinate() == destinationCoordinate) {
					return move;
				}
			}
			return NULL_MOVE;
		}
	}
}
