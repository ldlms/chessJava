package com.chess.engine.player;

import java.util.Collection;

import com.chess.engine.board.Board;
import com.chess.engine.board.Move;
import com.chess.engine.pieces.Piece;

public class BlackPlayer extends Player {

	public BlackPlayer(final Board board, final Collection<Move> blackStandardLegalMove,
			final Collection<Move> whiteStandardLegalMove) {
		super(board, blackStandardLegalMove, whiteStandardLegalMove);
	}

	@Override
	public Collection<Piece> getActivePiece() {
		return this.board.getBlackPieces();
	}

}
