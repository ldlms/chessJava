package com.chess.engine.board;

import java.util.HashMap;
import java.util.Map;

import com.chess.engine.pieces.Piece;
import com.google.common.collect.ImmutableMap;

public abstract class Tile {

	protected final int tileCoordinate;
	public static final Map<Integer, EmptyTile> EMPTY_TILES = createAllPossibleEmptyTiles();

	protected Tile(final int Coordinate) {
		this.tileCoordinate = Coordinate;
	}

	public static Tile createTile(final int coordinate, final Piece piece) {
		return piece != null ? new OccupiedTile(coordinate, piece) : EMPTY_TILES.get(coordinate);
	}

	private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {

		final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();
		for (int i = 0; i < BoardUtils.NUM_TILES; i++) {
			emptyTileMap.put(1, new EmptyTile(i));
		}
		// return emptyTileMap;
		return ImmutableMap.copyOf(emptyTileMap);

	}

	public abstract boolean isTileOccupied();

	public abstract Piece getPiece();

}
