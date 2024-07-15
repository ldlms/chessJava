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

	public Bishop(final Alliance pieceAlliance, final int piecePosition) {
		super(PieceType.BISHOP, piecePosition, pieceAlliance, true);
	}

	public Bishop(final Alliance pieceAlliance, final int piecePosition, final boolean isFirstMove) {
		super(PieceType.BISHOP, piecePosition, pieceAlliance, isFirstMove);
	}

	@Override
	public Collection<Move> calculateLegalMoves(final Board board) {

		final List<Move> legalMoves = new ArrayList<>();
		for (final int candidateCoordinateOffset : CANDIDATE_MOVE_VECTOR_COORDINATES) {
			int candidateDestinationCoordinate = this.piecePosition;
			while (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
				if (isFirstColumnExclusion(candidateDestinationCoordinate, candidateCoordinateOffset)
						|| isEighthColumnExclusion(candidateDestinationCoordinate, candidateCoordinateOffset)) {
					break;
				}
				System.out.println("allo");
				// problème dans la boucle ci-dessus
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
						break;
					}
				}
			}

		}
		System.out.println(legalMoves);
		return ImmutableList.copyOf(legalMoves);
	}

	@Override
	public String toString() {
		return PieceType.BISHOP.toString();
	}

	private static boolean isFirstColumnExclusion(final int currentPosition, final int candidateOffset) {
		return BoardUtils.FIRST_COLUMN[currentPosition] && (candidateOffset == -9 || candidateOffset == 7);
	}

	private static boolean isEighthColumnExclusion(final int currentPosition, final int candidateOffset) {
		return BoardUtils.EIGHTH_COLUMN[currentPosition] && (candidateOffset == -7 || candidateOffset == 9);
	}

	@Override
	public Bishop movePiece(Move move) {
		// TODO Auto-generated method stub
		return new Bishop(move.getMovedPiece().getAlliance(), move.getDestinationCoordinate());
	}
}
