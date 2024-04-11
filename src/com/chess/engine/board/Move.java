package com.chess.engine.board;

import com.chess.engine.pieces.Piece;

public abstract class Move {

	final Board board;
	final Piece movedPiece;
	final int destination;

	public Move(final Board board, final Piece movedPiece, final int destination) {
		this.board = board;
		this.movedPiece = movedPiece;
		this.destination = destination;
	}

	public int getDestinationCoordinate() {
		return this.destination;
	}

	public Piece getMovedPiece() {
		return this.movedPiece;
	}

	public abstract Board execute();
}
