package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.AppDTO;
import co.edu.unbosque.model.MainModel;
import co.edu.unbosque.view.MainView;

public class MainController implements ActionListener {

	private MainView MV;
	private MainModel MM;
	private AppDTO DTO;

	public MainController() {
		MV = new MainView();
		MM = new MainModel();
		DTO = new AppDTO();
		funcionar();
	}

	public void funcionar() {
		initListeners();
	}

	public void initListeners() {
		MV.getLoadBtn().addActionListener(this);
		MV.getMathHighscoreBtn().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "loadBtn":
			// System.out.println("Cargar datos presionado"); //Debug
			// Método que cargue los datos (modelo)
			DTO.setTableData(MM.generateRandomArray());
			DTO.setTableHeaders(MM.getColHeaders());
			MV.getTP().setModel(new DefaultTableModel(DTO.getTableData(), DTO.getTableHeaders()));
			// MV.getTP().setMainTable(new JTable());
			MV.getTP().loadTable();
			break;

		case "mathHighscoreBtn":
			// System.out.println("Boton presionado"); //Debug
			System.out.println(DTO.getMathHighscore());
			break;
		default:
			break;
		}
	}
}
