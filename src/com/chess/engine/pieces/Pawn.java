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

	private static final int[] CANDIDATE_MOVE_COORDINATE = { 7, 8, 9, 16 };

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
			} else if (currentCandidateOffset == 16 && this.isFirstMove()
					&& (BoardUtils.SECOND_ROW[this.piecePosition] && this.getAlliance().isBlack()
							|| (BoardUtils.SEVENTH_ROW[this.piecePosition] && this.getAlliance().isWhite()))) {
				final int behindCandidateDestinationCoordinate = this.piecePosition
						+ (8 * this.getAlliance().getDirection());
				if (!board.getTile(behindCandidateDestinationCoordinate).isTileOccupied()
						&& !board.getTile(candidatePiecePosition).isTileOccupied()) {
					legalMoves.add(new MajorMove(board, this, candidatePiecePosition));
				}
			} else if (currentCandidateOffset == 7 && BoardUtils.EIGHTH_COLUMN[this.piecePosition]
					&& this.getAlliance().isWhite()) {

			} else if (currentCandidateOffset == 9) {

			}
		}
		return null;
	}
}
