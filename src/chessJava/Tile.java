package chessJava;

public abstract class Tile {

	int tileCoordinate;

	Tile(int Coordinate) {
		this.tileCoordinate = Coordinate;
	}

	public abstract boolean isTileOccupied();

	public abstract Piece getPiece();

	public static final class EmptyTile extends Tile {

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
}
