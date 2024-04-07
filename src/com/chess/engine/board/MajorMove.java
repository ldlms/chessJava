package com.chess.engine.board;

import com.chess.engine.board.Board.Builder;
import com.chess.engine.pieces.Piece;

public final class MajorMove extends Move {

	public MajorMove(final Board board, final Piece movedPiece, final int destination) {
		super(board, movedPiece, destination);
	}

	@Override
	public Board execute() {
		final Builder builder = new Board.Builder();
		for (final Piece piece : this.board.currentPlayer().getActivePiece()) {
			if (!this.movedPiece.equals(piece)) {
				builder.setPiece(piece);
			}
		}
		for (final Piece piece : this.board.currentPlayer().getOpponent().getActivePiece()) {
			builder.setPiece(piece);
		}
		builder.setPiece(null);
		builder.setMoveMaker(this.board.currentPlayer().getOpponent().getAlliance());
		return builder.build();
	}
}
