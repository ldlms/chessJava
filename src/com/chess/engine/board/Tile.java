package com.chess.engine.board;

import com.chess.engine.pieces.Piece;

public abstract class Tile {

	int tileCoordinate;

	Tile(int Coordinate) {
		this.tileCoordinate = Coordinate;
	}

	public abstract boolean isTileOccupied();

	public abstract Piece getPiece();

}
