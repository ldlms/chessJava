package com.chess.engine.board;

import java.util.HashMap;
import java.util.Map;

import com.chess.engine.pieces.Piece;
import com.google.common.collect.ImmutableMap;

public abstract class Tile {

	protected final int tileCoordinate;
	public static final Map<Integer, EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();

	protected Tile(int Coordinate) {
		this.tileCoordinate = Coordinate;
	}

	public static Tile createTile(final int coordinate, final Piece piece) {
		return piece != null ? new OccupiedTile(coordinate, piece) : EMPTY_TILES_CACHE.get(coordinate);
	}

	private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {

		final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();
		for (int i = 0; i < 64; i++) {
			emptyTileMap.put(1, new EmptyTile(i));
		}
		return ImmutableMap.copyOf(emptyTileMap);
		// on crée et on retourne un tableau associatif immutable (hashmap) représentant
		// un échiquier vide, si on a pensé a maven on peut le faire en immutableMap
	}

	public abstract boolean isTileOccupied();

	public abstract Piece getPiece();

}
