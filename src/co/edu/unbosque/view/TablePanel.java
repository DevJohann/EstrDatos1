package co.edu.unbosque.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class TablePanel extends JPanel {

	private JTable mainTable;
	private TableModel model;
	private JScrollPane scroll;
	public static boolean isTableLoaded = false;

	public TablePanel() {

//		mainTable = new JTable(model);
//		mainTable.setBounds(10, 10, 480, 150);
//		add(mainTable);
	}

	public JTable getMainTable() {
		return mainTable;
	}

	public void setMainTable(JTable mainTable) {
		// this.mainTable = mainTable;
		mainTable = new JTable(model);
		mainTable.setBounds(10, 10, 480, 150);
		add(mainTable);
	}

	public TableModel getModel() {
		return model;
	}

	public void setModel(TableModel model) {
		this.model = model;
	}

	public void loadTable() {
		mainTable = new JTable(model);
		mainTable.setBounds(0, 0, 500, 200);
		scroll = new JScrollPane(mainTable);
		scroll.setBounds(0, 0, 500, 200);
		add(scroll);
		isTableLoaded = true;
		repaint();
	}

}
