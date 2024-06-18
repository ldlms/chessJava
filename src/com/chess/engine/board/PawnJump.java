package com.chess.engine.board;

import com.chess.engine.board.Board.Builder;
import com.chess.engine.pieces.Pawn;
import com.chess.engine.pieces.Piece;

public class PawnJump extends Move {

	public PawnJump(final Board board, final Piece movedPiece, final int destination) {
		super(board, movedPiece, destination);
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
			builder.setPiece(piece);
		}
		final Pawn movedPawn = (Pawn) this.movedPiece.movePiece(this);
		builder.setPiece(movedPawn);
		builder.setEnPassant(movedPawn);
		builder.setMoveMaker(this.board.currentPlayer().getOpponent().getAlliance());
		return builder.build();

	}
}
