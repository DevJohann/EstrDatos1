package co.edu.unbosque.model;

import java.text.DecimalFormat;

public class MainModel {

	private String[] colHeaders = { "Matemáticas", "Física", "Programación" };

	private DecimalFormat dataFormat = new DecimalFormat("0.0");

	public MainModel() {

	}

	public String[][] generateRandomArray() {

		String[][] returnableData = new String[10][3];
		// System.out.println(returnableData[0].length); //Debug

		// Load random data
		String randomNumber = "0";
		for (int i = 0; i < returnableData.length; i++) { // Rows
			for (int j = 0; j < returnableData[i].length; j++) { // Columns
				randomNumber = dataFormat.format((Math.random() * 5 + 1) - 1);
				returnableData[i][j] = randomNumber.replace(',', '.');
			}
		}

//		// Show generated data
//		for (int i = 0; i < returnableData.length - 1; i++) {
//			// Rows
//			for (int j = 0; j < returnableData[i].length; j++) { // Columns
//				System.out.print(returnableData[i][j] + " ");
//			}
//			System.out.println();
//		}

		return returnableData;
	}

	public String[] getColHeaders() {
		return colHeaders;
	}

	public void setColHeaders(String[] colHeaders) {
		this.colHeaders = colHeaders;
	}

}
