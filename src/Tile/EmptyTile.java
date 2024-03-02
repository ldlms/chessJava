package Tile;

import Piece.Piece;

public final class EmptyTile extends Tile {

	EmptyTile(int coordinate) {
		super(coordinate);
	}

	@Override
	public boolean isTileOccupied() {
		return false;
	}

	@Override
	public Piece getPiece() {
		return null;
	}
}
