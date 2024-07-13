package com.chess.engine.board;

import com.chess.engine.pieces.Piece;

public class PawnAttackMove extends AttackMove {

	public PawnAttackMove(final Board board, final Piece movedPiece, final Piece attackedPiece, final int coordinate) {
		super(board, movedPiece, attackedPiece, coordinate);
	}

	@Override
	public boolean equals(final Object other) {
		return this == other || other instanceof PawnAttackMove && super.equals(other);
	}

	@Override
	public String toString() {
		return BoardUtils.getPositionAtCoordinate(this.movedPiece.getPiecePosition()).substring(0, 1) + "x"
				+ BoardUtils.getPositionAtCoordinate(this.getDestinationCoordinate());
	}

}
