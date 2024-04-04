package com.chess.engine.player;

public enum MoveStatus {
	DONE {
		boolean isDone() {
			return true;
		}
	};

	abstract boolean isDone();

}
