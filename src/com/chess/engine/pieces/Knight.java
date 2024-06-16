package com.chess.engine.pieces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.chess.engine.Alliance;
import com.chess.engine.board.AttackMove;
import com.chess.engine.board.Board;
import com.chess.engine.board.BoardUtils;
import com.chess.engine.board.MajorMove;
import com.chess.engine.board.Move;
import com.chess.engine.board.Tile;
import com.google.common.collect.ImmutableList;

public final class Knight extends Piece {

	private final static int[] CANDIDATE_MOVE_COORDINATES = { -17, -15, -10, -6, 6, 10, 17 };

	public Knight(final Alliance pieceAlliance, final int piecePosition) {
		super(PieceType.KNIGHT, piecePosition, pieceAlliance, true);

	}

	public Knight(final Alliance pieceAlliance, final int piecePosition, final boolean isFirstMove) {
		super(PieceType.KNIGHT, piecePosition, pieceAlliance, isFirstMove);

	}

	@Override
	public Collection<Move> calculateLegalMoves(final Board board) {

		final List<Move> legalMoves = new ArrayList<>();

		for (final int CurrentCandidateOffset : CANDIDATE_MOVE_COORDINATES) {

			final int candidateDestinationCoordinate = this.piecePosition + CurrentCandidateOffset;
			if (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
				if (isFirstColumnExclusion(this.piecePosition, CurrentCandidateOffset)
						|| isSecondColumnExclusion(this.piecePosition, CurrentCandidateOffset)
						|| isSeventhColumnExclusion(this.piecePosition, CurrentCandidateOffset)
						|| isEighthColumnExclusion(this.piecePosition, CurrentCandidateOffset)) {
					continue;
				}
				final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);

				if (!candidateDestinationTile.isTileOccupied()) {
					legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
				} else {
					final Piece pieceAtDestination = candidateDestinationTile.getPiece();
					final Alliance pieceAlliance = pieceAtDestination.getAlliance();
					if (this.pieceAlliance != pieceAlliance) {
						legalMoves.add(new AttackMove(board, this, pieceAtDestination, candidateDestinationCoordinate));
					}
				}
			}
		}
		return ImmutableList.copyOf(legalMoves);
	}

	private static boolean isFirstColumnExclusion(final int currentPosition, final int candidateOffset) {
		return BoardUtils.FIRST_COLUMN[currentPosition]
				&& (candidateOffset == -17 || candidateOffset == -10 || candidateOffset == 6 || candidateOffset == 15);
	}

	private static boolean isSecondColumnExclusion(final int currentPosition, final int candidateOffset) {
		return BoardUtils.SECOND_COLUMN[currentPosition] && (candidateOffset == -10 || candidateOffset == 6);
	}

	private static boolean isSeventhColumnExclusion(final int currentPosition, final int candidateOffset) {
		return BoardUtils.SEVENTH_COLUMN[currentPosition] && (candidateOffset == -6 || candidateOffset == 10);
	}

	private static boolean isEighthColumnExclusion(final int currentPosition, final int candidateOffset) {
		return BoardUtils.EIGHTH_COLUMN[currentPosition]
				&& (candidateOffset == -15 || candidateOffset == -6 || candidateOffset == 10 || candidateOffset == 17);
	}

	@Override
	public String toString() {
		return PieceType.KNIGHT.toString();
	}

	@Override
	public Knight movePiece(Move move) {
		// TODO Auto-generated method stub
		return new Knight(move.getMovedPiece().getAlliance(), move.getDestinationCoordinate());
	}

	/*
	 * private boolean isValidTileCoordinate(int coordinate) { if
	 * (Tile.EMPTY_TILES_CACHE.containsKey(coordinate)) { return true; } else {
	 * return false; } }
	 */
}
