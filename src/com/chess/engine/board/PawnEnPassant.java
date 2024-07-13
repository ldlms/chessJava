package com.chess.engine.board;

import com.chess.engine.board.Board.Builder;
import com.chess.engine.pieces.Piece;

public class PawnEnPassant extends PawnAttackMove {

	public PawnEnPassant(final Board board, final Piece movedPiece, final Piece attackedPiece, final int coordinate) {
		super(board, attackedPiece, movedPiece, coordinate);
	}

	@Override
	public boolean equals(Object other) {
		return this == other || other instanceof PawnEnPassant && super.equals(other);
	}

	@Override
	public Board execute() {
		final Builder builder = new Builder();
		for (final Piece piece : this.board.currentPlayer().getActivePiece()) {
			if (!this.movedPiece.equals(piece)) {
				builder.setPiece(piece);
			}
		}
		for (final Piece piece : this.board.currentPlayer().getOpponent().getActivePiece()) {
			if (!piece.equals(this.getAttackedPiece())) {
				builder.setPiece(piece);
			}
		}
		builder.setPiece(this.movedPiece.movePiece(this));
		builder.setMoveMaker(this.board.currentPlayer().getOpponent().getAlliance());
		return builder.build();
	}
}
