package com.chess.engine.board;

public class NullMove extends Move {

	public NullMove() {
		super(null, -1);
	}

	@Override
	public Board execute() {
		throw new RuntimeException("Cannot execute the null move");
	}

	@Override
	public int getCurrentCoordinate() {
		return -1;
	}

	@Override
	public int getDestinationCoordinate() {
		return -1;
	}

	@Override
	public String toString() {
		return "Null Move";
	}
}
