package com.chess.engine.player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.CastleMove.KingSideCastleMove;
import com.chess.engine.board.CastleMove.QueenSideCastleMove;
import com.chess.engine.board.Move;
import com.chess.engine.board.Tile;
import com.chess.engine.pieces.Piece;
import com.chess.engine.pieces.Rook;
import com.google.common.collect.ImmutableList;

public class WhitePlayer extends Player {

	public WhitePlayer(final Board board, final Collection<Move> whiteStandardLegalMove,
			final Collection<Move> blackStandardLegalMove) {
		super(board, whiteStandardLegalMove, blackStandardLegalMove);
	}

	@Override
	public Collection<Piece> getActivePiece() {
		return this.board.getWhitePieces();
	}

	@Override
	public Alliance getAlliance() {
		return Alliance.WHITE;
	}

	@Override
	public Player getOpponent() {
		return this.board.blackPlayer();
	}

	@Override
	protected Collection<Move> calculateKingCastles(final Collection<Move> playerLegals,
			final Collection<Move> opponentsLegals) {

		final List<Move> kingCastles = new ArrayList<>();
		if (this.playerKing.isFirstMove() && !this.isInCheck()) {
			// kingSide
			if (!this.board.getTile(61).isTileOccupied() && !this.board.getTile(62).isTileOccupied()) {
				final Tile rookTile = this.board.getTile(63);
				if (rookTile.isTileOccupied() && rookTile.getPiece().isFirstMove()) {
					if (Player.calculateAttackOnTile(61, opponentsLegals).isEmpty()
							&& Player.calculateAttackOnTile(62, opponentsLegals).isEmpty()
							&& rookTile.getPiece().getPieceType().isRook()) {
						kingCastles.add(new KingSideCastleMove(this.board, this.playerKing, 62,
								(Rook) rookTile.getPiece(), rookTile.getTileCoordinate(), 61));
					}
				}
			}
			if (!this.board.getTile(59).isTileOccupied() && !this.board.getTile(58).isTileOccupied()
					&& !this.board.getTile(57).isTileOccupied()) {
				final Tile rookTile = this.board.getTile(56);
				if (rookTile.isTileOccupied() && rookTile.getPiece().isFirstMove()
						&& Player.calculateAttackOnTile(58, opponentsLegals).isEmpty()
						&& Player.calculateAttackOnTile(59, opponentsLegals).isEmpty()
						&& rookTile.getPiece().getPieceType().isRook()) {

					kingCastles.add(new QueenSideCastleMove(this.board, this.playerKing, 58, (Rook) rookTile.getPiece(),
							rookTile.getTileCoordinate(), 59));
					;
				}

			}
		}

		return ImmutableList.copyOf(kingCastles);
	}

}
