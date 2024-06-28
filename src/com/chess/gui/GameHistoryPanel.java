package com.chess.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.chess.engine.board.Board;
import com.chess.gui.Table.MoveLog;

public class GameHistoryPanel extends JPanel {

	private final DataModel model;
	private final JScrollPane scrollPane;
	private static final Dimension HISTORY_PANEL_DIMENSION = new Dimension(100, 400);

	GameHistoryPanel() {
		this.setLayout(new BorderLayout());
		this.model = new DataModel();
		final JTable table = new Jtable(model);
		table.setRowHeight(15);
		this.scrollPane = new JScrollPane(table);
		scrollPane.setColumnHeaderView(table.getTableHeader());
		scrollPane.setPreferredSize(HISTORY_PANEL_DIMENSION);
		this.add(scrollPane, BorderLayout.CENTER);
		this.setVisible(true);

	}

	void redo(final Board board, final MoveLog moveLog) {

	}

	private static class DataModel extends DefaultTableModel {
		private final List<Row> values;
		private static final String[] NAMES = { "white", "black" };

		DataModel() {
			this.values = new ArrayList<>();
		}

		public void clear() {
			this.values.clear();
			setRowCount(0);
		}

		@Override
		public int getRowCount() {
			if (this.values == null) {
				return 0;
			}
			return this.values.size();

		}

	}

	private static class Row {
		private String whiteMove;
		private String blackMove;

		Row() {
		}

		public String getWhiteMove() {
			return this.whiteMove;
		}

		public String getBlackMove() {
			return this.blackMove;
		}

		public void setWhiteMove(final String whiteMove) {
			this.whiteMove = whiteMove;
		}

		public void setBlackMove(final String blackMove) {
			this.blackMove = blackMove;
		}
	}
}
