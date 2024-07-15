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

public final class Rook extends Piece {

	private static final int[] CANDIDATE_MOVE_VECTOR_COORDINATES = { -8, -1, 1, 8 };

	public Rook(final Alliance pieceAlliance, final int piecePosition) {
		super(PieceType.ROOK, piecePosition, pieceAlliance, true);
	}

	public Rook(final Alliance pieceAlliance, final int piecePosition, final boolean isFirstMove) {
		super(PieceType.ROOK, piecePosition, pieceAlliance, isFirstMove);
	}

	@Override
	public Collection<Move> calculateLegalMoves(final Board board) {
		final List<Move> legalMoves = new ArrayList<>();

		for (final int candidateCoordinate : CANDIDATE_MOVE_VECTOR_COORDINATES) {
			int pieceCoordinate = this.piecePosition;
			while (BoardUtils.isValidTileCoordinate(pieceCoordinate)) {
				if (firstColumnException(pieceCoordinate, candidateCoordinate)
						|| eighthColumnException(pieceCoordinate, candidateCoordinate)) {
					break;
				}
				pieceCoordinate += candidateCoordinate;
				if (BoardUtils.isValidTileCoordinate(pieceCoordinate)) {
					final Tile TileDestination = board.getTile(pieceCoordinate);
					if (!TileDestination.isTileOccupied()) {
						legalMoves.add(new MajorMove(board, this, pieceCoordinate));
					} else {
						final Piece pieceAtDestination = TileDestination.getPiece();
						final Alliance pieceAlliance = pieceAtDestination.getAlliance();
						if (this.pieceAlliance != pieceAlliance) {
							legalMoves.add(new AttackMove(board, this, pieceAtDestination, pieceCoordinate));
						}
						break;
					}

				}
			}
		}
		return ImmutableList.copyOf(legalMoves);
	}

	private static boolean firstColumnException(final int currentPosition, final int candidateOffset) {
		return BoardUtils.FIRST_COLUMN[currentPosition] && candidateOffset == -1;
	}

	private static boolean eighthColumnException(final int currentPosition, final int candidateOffset) {
		return BoardUtils.EIGHTH_COLUMN[currentPosition] && candidateOffset == 1;
	}

	@Override
	public String toString() {
		return PieceType.ROOK.toString();
	}

	@Override
	public Rook movePiece(Move move) {
		// TODO Auto-generated method stub
		return new Rook(move.getMovedPiece().getAlliance(), move.getDestinationCoordinate());
	}
}
