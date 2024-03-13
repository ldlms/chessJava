package com.chess.engine.pieces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.BoardUtils;
import com.chess.engine.board.MajorMove;
import com.chess.engine.board.Move;

public class Pawn extends Piece {

	private static final int[] CANDIDATE_MOVE_COORDINATE = { 8, 16 };

	Pawn(final int pieceCoordinate, final Alliance pieceAlliance) {
		super(pieceCoordinate, pieceAlliance);
	}

	@Override
	public Collection<Move> calculateLegalMoves(Board board) {
		final List<Move> legalMoves = new ArrayList<>();
		for (final int currentCandidateOffset : CANDIDATE_MOVE_COORDINATE) {
			final int candidatePiecePosition = (this.piecePosition
					+ (this.getAlliance().getDirection() * currentCandidateOffset));
			if (!BoardUtils.isValidTileCoordinate(candidatePiecePosition)) {
				continue;
			}
			if (currentCandidateOffset == 8 && !board.getTile(candidatePiecePosition).isTileOccupied()) {
				legalMoves.add(new MajorMove(board, this, candidatePiecePosition));
			} else if (currentCandidateOffset == 16 && this.isFirstMove() && (true) || (true)) {

			}
		}
		return null;
	}
}
