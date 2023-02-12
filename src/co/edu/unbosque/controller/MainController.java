package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.AppDTO;
import co.edu.unbosque.model.MainModel;
import co.edu.unbosque.view.MainView;
import co.edu.unbosque.view.TablePanel;

public class MainController implements ActionListener {

	private MainView MV;
	private MainModel MM;
	private AppDTO DTO;

	private String response;

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
		MV.getBestHighscoreBtn().addActionListener(this);
		MV.getLowestSubject().addActionListener(this);
		MV.getHighestSubject().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "loadBtn":
			// System.out.println("Cargar datos presionado"); //Debug
			// Método que cargue los datos (modelo)
			if (TablePanel.isTableLoaded) {
				JOptionPane.showMessageDialog(null, "La tabla ya fue cargada");
				break;
			} else {
				DTO.setTableData(MM.generateRandomArray());
				DTO.setTableHeaders(MM.getColHeaders());
				MV.getTP().setModel(new DefaultTableModel(DTO.getTableData(), DTO.getTableHeaders()));
				// MV.getTP().setMainTable(new JTable());
				MV.getTP().loadTable();
			}
			break;

		case "mathHighscoreBtn":
			// System.out.println("Boton presionado"); //Debug
			response = DTO.getMathHighscore(TablePanel.isTableLoaded);
			if (response.equals("Tabla no cargada"))
				JOptionPane.showMessageDialog(null, "Debe cargar primero la tabla de notas");
			else
				JOptionPane.showMessageDialog(null, response);

			break;

		case "bestHighscoreBtn":
			// System.out.println("Botón preisonado"); //Debug
			response = DTO.getBestHighscore(TablePanel.isTableLoaded);
			if (response.equals("Tabla no cargada"))
				JOptionPane.showMessageDialog(null, "Debe cargar primero la tabla de notas");
			else
				JOptionPane.showMessageDialog(null, response);

			break;

		case "lowestSubject":
			// System.out.println("Botón presionado"); //Debug
			// Check table
			response = DTO.getLowestSubject(TablePanel.isTableLoaded);
			if (response.equals("Tabla no cargada"))
				JOptionPane.showMessageDialog(null, "Debe cargar primero la tabla de notas");
			else
				JOptionPane.showMessageDialog(null, response);
			break;

		case "highestSubject":
			// System.out.println("Botón presonado"); //Debug
			response = DTO.getHighestSubject(TablePanel.isTableLoaded);
			if (response.equals("Tabla no cargada"))
				JOptionPane.showMessageDialog(null, "Debe cargar primero la tabla de notas");
			else
				JOptionPane.showMessageDialog(null, response);
			break;

		default:
			break;
		}
	}
}
