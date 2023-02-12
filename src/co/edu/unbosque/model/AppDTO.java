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
				// System.out.print("Sumando " + suma + " con " + tableData[i][j] + " (fila: " +
				// i + ")" + " "); //Debug
			}
			score = dataFormat.format(suma / 3);
			parsedScore = Double.parseDouble(score.replace(',', '.'));
			// System.out.println("Promedio: " + parsedScore);
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

	public String getLowestSubject(boolean isTableLoaded) {
		ArrayList<Double> sumList = new ArrayList<Double>();
		if (!isTableLoaded) {
			return "Tabla no cargada";
		}
		// System.out.println(tableData[0].length); //Debug: 3
		int cols = tableData[0].length;
		int rows = tableData.length;
		// System.out.println("Rows: " + rows); //Debug
		Double sumaCol = 0.0;
		for (int i = 0; i < cols; i++) {
			sumaCol = 0.0;
			for (int j = 0; j < rows; j++) {
				sumaCol += Double.parseDouble(tableData[j][i]);
			}
			// System.out.println("Añade al arraylist: " + sumaCol / 10); //Debug
			sumList.add(sumaCol / 10);
		}
		// Check lowest value from arraylist
		Double minimum = sumList.get(0);
		int col = 0;
		for (int i = 1; i < sumList.size(); i++) {
			if (minimum > sumList.get(i)) {
				minimum = sumList.get(i);
				col = i;
			}
		}
		String realMinimum = dataFormat.format(minimum);
		Double parsedMinimum = Double.parseDouble(realMinimum.replace(',', '.'));

		// Check lowest subject amount of less than 3.0 values
		int contador = 0;
		// System.out.println(tableData[0][2]); //Debug
		for (int i = 0; i < tableData.length; i++) {
			// System.out.println("Analizando " + tableData[i][col]); //Debug
			if (Double.parseDouble(tableData[i][col]) < 3.0) {
				contador++;
			}
		}

		String subject = "";
		switch (col + 1) {
		case 1, 0:
			subject = "Matemáticas";
			break;
		case 2:
			subject = "Física";
			break;
		case 3:
			subject = "Programación";
			break;
		default:
			return "Error al analizar la materia";
		}
		return "La materia con mayores pérdidas es " + subject + " con un promedio de " + parsedMinimum + " y "
				+ contador + " pérdidas";
	}

	public String getHighestSubject(boolean isTableLoaded) {
		ArrayList<Double> sumList = new ArrayList<Double>();
		if (!isTableLoaded) {
			return "Tabla no cargada";
		}

		int cols = tableData[0].length;
		int rows = tableData.length;
		Double sumaCol = 0.0;
		for (int i = 0; i < cols; i++) {
			sumaCol = 0.0;
			for (int j = 0; j < rows; j++) {
				sumaCol += Double.parseDouble(tableData[j][i]);
			}
			// System.out.println("Añade al arraylist: " + sumaCol / 10); //Debug
			sumList.add(sumaCol / 10);
		}
		// Check highest value from arraylist
		Double maximum = sumList.get(0);
		int col = 0;
		for (int i = 1; i < sumList.size(); i++) {
			if (maximum < sumList.get(i)) {
				maximum = sumList.get(i);
				col = i + 1;
			}
		}
		// Parse float
		String strMax = dataFormat.format(maximum);
		Double parsedMaximum = Double.parseDouble(strMax.replace(',', '.'));

		// Check subject index
		String subject = "";
		switch (col) {
		case 1:
			subject = "Matemáticas";
			break;
		case 2:
			subject = "Fïsica";
			break;
		case 3:
			subject = "Programación";
			break;
		default:
			return "Error detectando la materia";
		}
		return "La materia con mejor promedio es " + subject + " con " + parsedMaximum;
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
