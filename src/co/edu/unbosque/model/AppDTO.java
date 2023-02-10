package co.edu.unbosque.model;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class AppDTO {

	private String[][] tableData;
	private String[] tableHeaders;

	private DecimalFormat dataFormat = new DecimalFormat("0.0");

	public AppDTO() {

	}

	public String getMathHighscore(boolean isTableLoaded) {
		if (!isTableLoaded) {
			return "Tabla no cargada";
		}
		double maxValue = Double.parseDouble(tableData[0][0]);
		int maxRow = 0;
		int maxCol = 0;
		for (int i = 0; i < tableData.length; i++) { // Rows
			for (int j = 0; j < 1; j++) { // Col
				if (Double.parseDouble(tableData[i][j]) > maxValue) {
					maxValue = Double.parseDouble(tableData[i][j]);
					maxRow = i + 1;
					maxCol = j + 1;
					break;
				}
			}
		}
		return "El valor máximo es " + maxValue + " ubicado en la fila " + maxRow + " columna " + maxCol;
	}

	public String getBestHighscore(boolean isTableLoaded) {
		if (!isTableLoaded) {
			return "Tabla no cargada";
		}
		Double suma = 0.0;
		String score = "0.0";
		Double parsedScore = 0.0;
		ArrayList<Double> scoreList = new ArrayList<Double>();
		for (int i = 0; i < tableData.length; i++) {
			for (int j = 0; j < tableData[i].length; j++) {
				suma += Double.parseDouble(tableData[i][j]);
				System.out.print("Sumando " + suma + " con " + tableData[i][j] + " (fila: " + i + ")" + " ");
			}
			score = dataFormat.format(suma / 3);
			parsedScore = Double.parseDouble(score.replace(',', '.'));
			System.out.println("Promedio: " + parsedScore);
			scoreList.add(parsedScore);
			suma = 0.0;
		}

		Double maximum = scoreList.get(0);
		int row = 0;
		for (int i = 1; i < scoreList.size(); i++) {
			if (maximum < scoreList.get(i)) {
				maximum = scoreList.get(i);
				row = i + 1;
			}
		}
		return "El mejor promedio es " + maximum + " en la fila " + row;
	}

	public String[][] getTableData() {
		return tableData;
	}

	public void setTableData(String[][] tableData) {
		this.tableData = tableData;
	}

	public String[] getTableHeaders() {
		return tableHeaders;
	}

	public void setTableHeaders(String[] tableHeaders) {
		this.tableHeaders = tableHeaders;
	}

}
