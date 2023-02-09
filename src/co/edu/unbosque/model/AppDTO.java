package co.edu.unbosque.model;

public class AppDTO {

	private String[][] tableData;
	private String[] tableHeaders;

	public AppDTO() {

	}

	public String getMathHighscore() {
		// TODO: Revisar que ya esté cargado la tabla
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
