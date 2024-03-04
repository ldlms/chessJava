package com.chess.engine.board;

import com.chess.engine.pieces.Piece;

public final class OccupiedTile extends Tile {

	private final Piece pieceOnTile;

	OccupiedTile(final int coordinate, Piece pieceOnTile) {
		super(coordinate);
		this.pieceOnTile = pieceOnTile;
	}

	@Override
	public boolean isTileOccupied() {
		return true;
	}

	@Override
	public Piece getPiece() {
		return this.pieceOnTile;
	}
}
