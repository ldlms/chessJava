package com.chess.engine.pieces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;

public class Pawn extends Piece {

	private static final int[] CANDIDATE_MOVE_COORDINATE = { 8 };

	Pawn(final int pieceCoordinate, final Alliance pieceAlliance) {
		super(pieceCoordinate, pieceAlliance);
	}

	@Override
	public Collection<Move> calculateLegalMoves(Board board) {
		final List<Move> legalMoves = new ArrayList<>();
		for (final int candidateOffset : CANDIDATE_MOVE_COORDINATE) {

		}
		return null;
	}
}
