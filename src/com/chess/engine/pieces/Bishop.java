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

public final class Bishop extends Piece {

	private final static int[] CANDIDATE_MOVE_VECTOR_COORDINATES = { -9, -7, 7, 9 };

	Bishop(final int piecePosition, final Alliance pieceAlliance) {
		super(piecePosition, pieceAlliance);
	}

	@Override
	public Collection<Move> calculateLegalMoves(final Board board) {

		final List<Move> legalMoves = new ArrayList<>();
		for (final int candidateCoordinateOffset : CANDIDATE_MOVE_VECTOR_COORDINATES) {
			int candidateDestinationCoordinate = this.piecePosition;
			while (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
				candidateDestinationCoordinate += candidateCoordinateOffset;

				if (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
					final Tile DestinationTile = board.getTile(candidateDestinationCoordinate);
					if (!DestinationTile.isTileOccupied()) {
						legalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
					} else {
						final Piece pieceAtDestination = DestinationTile.getPiece();
						final Alliance pieceAlliance = pieceAtDestination.getAlliance();
						if (this.pieceAlliance != pieceAlliance) {
							legalMoves.add(
									new AttackMove(board, this, pieceAtDestination, candidateDestinationCoordinate));
						}
					}
					break;
				}
			}

		}
		return ImmutableList.copyOf(legalMoves);
	}
}
