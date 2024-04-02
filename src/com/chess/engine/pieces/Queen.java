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

public class Queen extends Piece {

	private static final int[] CANDIDATE_MOVE_VECTOR_COORDINATES = { -9, -8, -7, -1, 1, 7, 8, 9 };

	public Queen(final Alliance pieceAlliance, final int piecePosition) {
		super(PieceType.QUEEN, piecePosition, pieceAlliance);
	}

	@Override
	public Collection<Move> calculateLegalMoves(Board board) {
		final List<Move> legalMoves = new ArrayList<>();

		for (final int candidateCoordinate : CANDIDATE_MOVE_VECTOR_COORDINATES) {
			int piecePosition = this.piecePosition;
			while (BoardUtils.isValidTileCoordinate(piecePosition)) {
				if (isFirstColumnException(piecePosition, candidateCoordinate)
						|| isEighthColumnException(piecePosition, candidateCoordinate)) {
					break;
				}
				piecePosition += candidateCoordinate;
				if (BoardUtils.isValidTileCoordinate(piecePosition)) {
					final Tile destinationTile = board.getTile(piecePosition);
					if (!destinationTile.isTileOccupied()) {
						legalMoves.add(new MajorMove(board, this, piecePosition));
					} else {
						final Piece pieceAtDestination = destinationTile.getPiece();
						final Alliance pieceAlliance = pieceAtDestination.getAlliance();
						if (this.pieceAlliance != pieceAlliance) {
							legalMoves.add(new AttackMove(board, this, pieceAtDestination, piecePosition));
						}
						break;
					}
				}
			}
		}
		return ImmutableList.copyOf(legalMoves);
	}

	private static boolean isFirstColumnException(final int currentPosition, final int candidateOffset) {
		return BoardUtils.FIRST_COLUMN[currentPosition]
				&& (candidateOffset == -9 || candidateOffset == -1 || candidateOffset == 7);
	}

	private static boolean isEighthColumnException(final int currentPosition, final int candidateOffset) {
		return BoardUtils.EIGHTH_COLUMN[currentPosition]
				&& (candidateOffset == -7 || candidateOffset == 1 || candidateOffset == 9);
	}

	@Override
	public String toString() {
		return PieceType.QUEEN.toString();
	}
}
