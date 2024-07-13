package com.chess.engine.board;

import com.chess.engine.pieces.Piece;

public class AttackMove extends Move {

	final Piece attackedPiece;

	public AttackMove(final Board board, final Piece movedPiece, final Piece attackedPiece, final int coordinate) {
		super(board, movedPiece, coordinate);
		this.attackedPiece = attackedPiece;
	}

	@Override
	public int hashCode() {
		return this.attackedPiece.hashCode() + super.hashCode();
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AttackMove)) {
			return false;
		}
		final AttackMove otherAttackMove = (AttackMove) other;
		return super.equals(otherAttackMove) && getAttackedPiece().equals(otherAttackMove.getAttackedPiece());

	}

	@Override
	public boolean isAttack() {
		return true;
	}

	@Override
	public Piece getAttackedPiece() {
		return this.attackedPiece;
	}

	public static class MajorAttackMove extends AttackMove {

		public MajorAttackMove(final Board board, final Piece movedPiece, final int destinationCoordinate,
				final Piece attackedPiece) {
			super(board, movedPiece, attackedPiece, destinationCoordinate);
		}

		@Override
		public boolean equals(Object other) {
			return this == other || other instanceof MajorAttackMove && super.equals(other);
		}

		@Override
		public String toString() {
			return movedPiece.getPieceType() + BoardUtils.getPositionAtCoordinate(this.destination);
		}
	}

}
