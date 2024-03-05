package com.chess.engine.pieces;

import java.util.List;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;

public final class Knight extends Piece {

	Knight(final int piecePosition, final Alliance pieceAlliance) {
		super(piecePosition, pieceAlliance);

	}

	@Override
	public List<Move> calculateLegalMoves(Board board) {
		return null;
	}
}
