package Tile;

import Piece.Piece;

public final class OccupiedTile extends Tile {

	Piece pieceOnTile;

	OccupiedTile(int coordinate, Piece pieceOnTile) {
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
