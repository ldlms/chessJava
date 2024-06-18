package com.chess.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class TakenPiecesPanel extends JPanel {

	private final JPanel northPanel;
	private final JPanel southPanel;

	private static final EtchedBorder PANEL_BORDER = new EtchedBorder(EtchedBorder.RAISED);

	public TakenPiecesPanel() {
		super(new BorderLayout());
		setBackground(Color.decode("0xFDF5E"));
		setBorder(PANEL_BORDER);
		this.northPanel = new JPanel(new GridLayout(8, 2));
		this.southPanel = new JPanel(new GridLayout(8, 2));
		this.northPanel.setBackground(PANEL_COLOR);
		this.southPanel.setBackground(PANEL_COLOR);
	}
}
