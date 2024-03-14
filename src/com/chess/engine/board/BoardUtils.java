package com.chess.engine.board;

public class BoardUtils {

	private BoardUtils() {
		throw new RuntimeException("Non");
	}

	public static final boolean[] FIRST_COLUMN = initColumn(0);
	public static final boolean[] SECOND_COLUMN = initColumn(1);
	public static final boolean[] SEVENTH_COLUMN = initColumn(6);
	public static final boolean[] EIGHTH_COLUMN = initColumn(7);
	public static final boolean[] SECOND_ROW = initRow(9);
	public static final boolean[] SEVENTH_ROW = initRow(56);

	static final int NUM_TILES = 64;
	public static final int NUM_TILES_PER_ROW = 8;

	private static boolean[] initColumn(int columnNumber) {
		final boolean[] column = new boolean[NUM_TILES];
		do {
			column[columnNumber] = true;
			columnNumber += NUM_TILES_PER_ROW;
		} while (columnNumber < NUM_TILES);
		return column;
	}

	private static boolean[] initRow(int rowNumber) {
		final boolean[] row = new boolean[NUM_TILES];
		do {
			row[rowNumber] = true;
			rowNumber += 1;
		} while (rowNumber < 17);
		return row;
	}

	public static boolean isValidTileCoordinate(final int coordinate) {
		return coordinate >= 0 && coordinate < NUM_TILES;
	}

}
