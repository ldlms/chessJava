package com.chess.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import com.chess.engine.pieces.Piece;
import com.chess.gui.Table.MoveLog;

public class TakenPiecesPanel extends JPanel {

	private final JPanel northPanel;
	private final JPanel southPanel;

	private static final Color PANEL_COLOR = Color.decode("0xFDFE6");
	private static final Dimension TAKEN_PIECE_DIMENSION = new Dimension(40, 80);
	private static final EtchedBorder PANEL_BORDER = new EtchedBorder(EtchedBorder.RAISED);

	public TakenPiecesPanel() {
		super(new BorderLayout());
		setBackground(PANEL_COLOR);
		setBorder(PANEL_BORDER);
		this.northPanel = new JPanel(new GridLayout(8, 2));
		this.southPanel = new JPanel(new GridLayout(8, 2));
		this.northPanel.setBackground(PANEL_COLOR);
		this.southPanel.setBackground(PANEL_COLOR);
		this.add(this.northPanel, BorderLayout.NORTH);
		this.add(this.southPanel, BorderLayout.SOUTH);
		setPreferredSize(TAKEN_PIECE_DIMENSION);

	}

	public void redo(final MoveLog moveLog) {
		this.southPanel.removeAll();
		this.northPanel.removeAll();

		final List<Piece> whiteTakenPieces = new ArrayList<>();
		final List<Piece> blackTAkenPieces = new ArrayList<>();
	}
}
