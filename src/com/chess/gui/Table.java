package com.chess.gui;

import static javax.swing.SwingUtilities.isLeftMouseButton;
import static javax.swing.SwingUtilities.isRightMouseButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.chess.engine.board.Board;
import com.chess.engine.board.BoardUtils;
import com.chess.engine.board.Move;
import com.chess.engine.board.Tile;
import com.chess.engine.pieces.Piece;

public class Table {

	private final JFrame gameFrame;
	private final BoardPanel boardPanel;
	private final Board chessBoard;
	private Tile sourceTile;
	private Tile destinationTile;
	private Piece humanMovedPiece;

	private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(600, 600);
	private final static Dimension BOARD_PANEL_DIMENSION = new Dimension(400, 350);
	private final static Dimension TILE_PANEL_DIMENSION = new Dimension(10, 10);
	private static String defaultPieceImagesPath = "art/";
	private final Color lightTileColor = Color.decode("#FFFACD");
	private final Color darkTileColor = Color.decode("#593E1A");

	public Table() {
		this.gameFrame = new JFrame("JChess");
		this.gameFrame.setLayout(new BorderLayout());
		final JMenuBar tableMenuBar = createTableMenuBar();
		this.gameFrame.setJMenuBar(tableMenuBar);
		this.gameFrame.setSize(OUTER_FRAME_DIMENSION);
		this.chessBoard = Board.createStandardBoard();
		this.boardPanel = new BoardPanel();
		this.gameFrame.add(this.boardPanel, BorderLayout.CENTER);
		this.gameFrame.setVisible(true);
	}

	private JMenuBar createTableMenuBar() {
		final JMenuBar tableMenuBar = new JMenuBar();
		tableMenuBar.add(createFileMenu());
		return tableMenuBar;
	}

	private JMenu createFileMenu() {
		final JMenu fileMenu = new JMenu("File");

		final JMenuItem openPGN = new JMenuItem("load PGN file");
		openPGN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("open the PGN file");
			}
		});
		fileMenu.add(openPGN);
		final JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		fileMenu.add(exitMenuItem);
		return fileMenu;
	}

	private class BoardPanel extends JPanel {

		final List<TilePanel> boardTiles;

		BoardPanel() {
			super(new GridLayout(8, 8));
			this.boardTiles = new ArrayList<>();
			for (int i = 0; i < BoardUtils.NUM_TILES; i++) {
				final TilePanel tilePanel = new TilePanel(this, i);
				this.boardTiles.add(tilePanel);
				add(tilePanel);
			}
			setPreferredSize(BOARD_PANEL_DIMENSION);
			validate();
		}
	}

	private class TilePanel extends JPanel {

		private final int tileId;

		TilePanel(final BoardPanel boardPanel, final int tileId) {
			super(new GridBagLayout());
			this.tileId = tileId;
			setPreferredSize(TILE_PANEL_DIMENSION);
			assignTileColor();
			assignPieceIcon(chessBoard);
			addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(final MouseEvent e) {

					if (isRightMouseButton(e)) {
						sourceTile = null;
						destinationTile = null;
						humanMovedPiece = null;
					} else if (isLeftMouseButton(e)) {
						// premier clic
						if (sourceTile == null) {
							sourceTile = chessBoard.getTile(tileId);
							humanMovedPiece = sourceTile.getPiece();
							if (humanMovedPiece == null) {
								sourceTile = null;
							}
						} else {
							// second clic
							destinationTile = chessBoard.getTile(tileId);
							final Move move = null;
						}

					}
				}

				@Override
				public void mousePressed(final MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(final MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(final MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(final MouseEvent e) {
					// TODO Auto-generated method stub

				}

			});
			validate();
		}

		private void assignPieceIcon(final Board board) {
			this.removeAll();
			if (board.getTile(this.tileId).isTileOccupied()) {

				try {
					final BufferedImage image = ImageIO.read(new File(defaultPieceImagesPath
							+ board.getTile(this.tileId).getPiece().getAlliance().toString().substring(0, 1)
							+ board.getTile(this.tileId).getPiece().toString() + ".gif"));
					add(new JLabel(new ImageIcon(image)));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		private void assignTileColor() {
			if (BoardUtils.EIGHTH_RANK[this.tileId] || BoardUtils.SIXTH_RANK[this.tileId]
					|| BoardUtils.FOURTH_RANK[this.tileId] || BoardUtils.SECOND_RANK[this.tileId]) {
				setBackground(this.tileId % 2 == 0 ? lightTileColor : darkTileColor);
			} else if (BoardUtils.SEVENTH_RANK[this.tileId] || BoardUtils.FITH_RANK[this.tileId]
					|| BoardUtils.THIRD_RANK[this.tileId] || BoardUtils.FIRST_RANK[this.tileId]) {
				setBackground(this.tileId % 2 != 0 ? lightTileColor : darkTileColor);
			}

		}
	}
}
