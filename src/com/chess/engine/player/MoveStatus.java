package com.chess.engine.player;

public enum MoveStatus {
	DONE {
		public boolean isDone() {
			return true;
		}
	},
	ILLEGAL_MOVE {
		@Override
		public boolean isDone() {
			return false;
		}

	},
	LEAVES_PLAYER_IN_CHECK {
		@Override
		public boolean isDone() {
			// TODO Auto-generated method stub
			return false;
		}
	};

	public abstract boolean isDone();

}
