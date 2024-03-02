package Tile;

import Piece.Piece;

public abstract class Tile {

	int tileCoordinate;

	Tile(int Coordinate) {
		this.tileCoordinate = Coordinate;
	}

	public abstract boolean isTileOccupied();

	public abstract Piece getPiece();

}
