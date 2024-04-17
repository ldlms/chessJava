package com.chess.engine.board;

public class NullMove extends Move {

	public NullMove() {
		super(null, null, -1);
	}

	@Override
	public Board execute() {
		throw new RuntimeException("Cannot execute the null move");
	}
}
