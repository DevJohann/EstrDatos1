package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.MainModel;
import co.edu.unbosque.view.MainView;

public class MainController implements ActionListener {

	private MainView MV;
	private MainModel MM;

	public MainController() {
		MV = new MainView();
		MM = new MainModel();
		funcionar();
	}

	public void funcionar() {
		initListeners();
	}

	public void initListeners() {
		MV.getLoadBtn().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "loadBtn":
			// System.out.println("Cargar datos presionado"); //Debug
			// Método que cargue los datos (modelo)
			MV.getTP().setModel(new DefaultTableModel(MM.generateRandomArray(), MM.getColHeaders()));
			// MV.getTP().setMainTable(new JTable());
			MV.getTP().loadTable();
			break;
		default:
			break;
		}
	}
}
