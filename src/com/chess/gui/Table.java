package com.chess.gui;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Table {

	private final JFrame gameFrame;

	private static Dimension OUTER_FRAME_DIMENSION = new Dimension(600, 600);

	public Table() {
		this.gameFrame = new JFrame("Jchess");

		this.gameFrame.setSize(OUTER_FRAME_DIMENSION);
		this.gameFrame.setVisible(true);
	}
}
