package com.chess.engine.pieces;

import java.util.ArrayList;
import java.util.List;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.BoardUtils;
import com.chess.engine.board.Move;
import com.chess.engine.board.Tile;
import com.google.common.collect.ImmutableList;

public final class Knight extends Piece {

	private final static int[] CANDIDATE_MOVE_COORDINATES = { -17, -15, -10, -6, 6, 10, 17 };

	Knight(final int piecePosition, final Alliance pieceAlliance) {
		super(piecePosition, pieceAlliance);

	}

	@Override
	public List<Move> calculateLegalMoves(Board board) {

		int candidateDestinationCoordinate;
		final List<Move> legalMoves = new ArrayList<>();

		for (final int currentCoordinate : CANDIDATE_MOVE_COORDINATES) {

			candidateDestinationCoordinate = this.piecePosition + currentCoordinate;
			if (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
				final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);

				if (!candidateDestinationTile.isTileOccupied()) {
					legalMoves.add(new Move());
				} else {
					final Piece pieceAtDestination = candidateDestinationTile.getPiece();
					final Alliance pieceAlliance = pieceAtDestination.getAlliance();
					if (this.pieceAlliance != pieceAlliance) {
						legalMoves.add(new Move());
					}
				}
			}
		}
		return ImmutableList.copyOf(legalMoves);
	}

	/*
	 * private boolean isValidTileCoordinate(int coordinate) { if
	 * (Tile.EMPTY_TILES_CACHE.containsKey(coordinate)) { return true; } else {
	 * return false; } }
	 */
}
