package com.chess.engine.pieces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.BoardUtils;
import com.chess.engine.board.Move;

public final class Rook extends Piece {

	private static final int[] CANDIDATE_MOVE_VECTOR_COORDINATES = { -8, -1, 1, 8 };

	Rook(final int piecePosition, final Alliance pieceAlliance) {
		super(piecePosition, pieceAlliance);
	}

	@Override
	public Collection<Move> calculateLegalMoves(Board board) {
		final List<Move> legalMoves = new ArrayList<>();

		for (final int candidateCoordinate : CANDIDATE_MOVE_VECTOR_COORDINATES) {
			int pieceCoordinate = this.piecePosition;
			while (BoardUtils.isValidTileCoordinate(pieceCoordinate)) {

			}
		}
		return null;
	}
}
