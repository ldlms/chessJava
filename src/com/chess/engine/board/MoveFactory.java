package com.chess.engine.board;

public class MoveFactory {

	private MoveFactory() {
		throw new RuntimeException("not instanciable");
	}

	public static Move createMove(final Board board, final int currentCoordinate, final int destinationCoordinate) {
		for (final Move move : board.getAllLegalMoves()) {
			if (move.getCurrentCoordinate() == currentCoordinate
					&& move.getDestinationCoordinate() == destinationCoordinate) {
				return move;
			}
		}
		return Move.NULL_MOVE;
	}
}
