/**
 * 
 */
package com.uxcautomation.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author tarundeepsharma
 *
 */
public class DataReaderExcel {
	public static String fileToRead = "";
	public static InputStream inputStream;
	public Workbook workbook;
	public static String browser = System.getProperty("Browser");

	public DataReaderExcel(String fileToRead) throws IOException {
		DataReaderExcel.fileToRead = fileToRead;
		workbook = new XSSFWorkbook(getInputStream());
	}

	public InputStream getInputStream() {
		inputStream = DataReaderExcel.class.getClassLoader().getResourceAsStream(fileToRead);
		return inputStream;

	}

	/**
	 * @return the Parameters for Junit tests
	 * @throws IOException
	 */
	// @SuppressWarnings("rawtypes")
	public Collection<Object> returnData() throws IOException {

		Sheet firstSheet = workbook.getSheetAt(0);

		ArrayList<Object> rows = new ArrayList<Object>();
		ArrayList<Object> rowData = new ArrayList<Object>();

		int numberOfColumns = getNonEmptyColumns(firstSheet);
		for (Row row : firstSheet) {
			if (isEmpty(row)) {
				break;
			} else {
				rowData.clear();
				for (int column = 0; column < numberOfColumns; column++) {
					Cell cell = row.getCell(column);

					rowData.add(objectFrom(workbook, cell));
				}
				if (row.getRowNum() > 0) {
					rows.add(rowData.toArray());
				}
			}
		}

		System.out.println("**********");
		workbook.close();
		inputStream.close();
		return rows;
	}

	public ArrayList<List<String>> returnDataRows() throws IOException {

		Sheet firstSheet = workbook.getSheetAt(0);

		ArrayList<List<String>> rows = new ArrayList<List<String>>();
		ArrayList<String> rowData = new ArrayList<String>();

		int numberOfColumns = getNonEmptyColumns(firstSheet);

		for (Row row : firstSheet) {
			if (isEmpty(row)) {
				break;
			} else {
				rowData.clear();
				for (int column = 0; column < numberOfColumns; column++) {
					Cell cell = row.getCell(column);

					rowData.add((String) objectFrom(workbook, cell));
				}

				if (row.getRowNum() > 0) {

					rows.add(rowData);
				}

			}
			rowData = new ArrayList<String>();

		}

		System.out.println("**********");
		workbook.close();
		inputStream.close();
		return rows;
	}

	/**
	 * Count the number of columns, using the number of non-empty cells in the
	 * first row.
	 */
	public int getNonEmptyColumns(final Sheet sheet) {
		Row firstRow = sheet.getRow(0);
		return firstEmptyCellPosition(firstRow);
	}

	private int firstEmptyCellPosition(final Row cells) {
		int columnCount = 0;
		for (Cell cell : cells) {
			if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				break;
			}
			columnCount++;
		}
		return columnCount;
	}

	public boolean isEmpty(final Row row) {
		Cell firstCell = row.getCell(0);
		boolean rowIsEmpty = (firstCell == null) || (firstCell.getCellType() == Cell.CELL_TYPE_BLANK);
		return rowIsEmpty;
	}

	public Object objectFrom(final Workbook workbook, final Cell cell) {
		Object cellValue = null;

		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			cellValue = cell.getStringCellValue();
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			cellValue = cell.getBooleanCellValue();
			break;
		case Cell.CELL_TYPE_NUMERIC:
			cellValue = cell.getNumericCellValue();
			break;
		}
		return cellValue;

	}

	public Sheet getSheet(int num) {

		Sheet firstSheet = workbook.getSheetAt(num);
		return firstSheet;
	}

	public ArrayList<ArrayList<String>> getDataRowsFromExcelAsSeperateList() throws IOException {

		Sheet firstSheet = getSheet(0);

		ArrayList<ArrayList<String>> rowList = new ArrayList<ArrayList<String>>();
		int numberOfColumns = getNonEmptyColumns(firstSheet);
		System.out.println("Reading property of browser: " + browser);
		if (browser == null) {
			browser = "MacFirefox";
		}
		for (Row row : firstSheet) {
			if (isEmpty(row)) {
				break;
			} else {
				// rowData.clear();
				ArrayList<String> rowData = new ArrayList<String>();
				for (int column = 0; column < numberOfColumns; column++) {
					Cell cell = row.getCell(column);

					if (row.getRowNum() > 0) {


							rowData.add(objectFrom(workbook, cell).toString());

					}
				}
				System.out.println(rowData);
				rowList.add(rowData);
			}
		}

		System.out.println("**********");
		workbook.close();
		inputStream.close();
		return rowList;
	}

	public ArrayList<String> getDataRowsFromExcel() throws IOException {

		Sheet firstSheet = getSheet(0);

		ArrayList<String> rowData = new ArrayList<String>();

		int numberOfColumns = getNonEmptyColumns(firstSheet);
		System.out.println("Reading property of browser: " + browser);
		if (browser == null) {
			browser = "MacFirefox";
		}
		for (Row row : firstSheet) {
			if (isEmpty(row)) {
				break;
			} else {
				// rowData.clear();
				for (int column = 0; column < numberOfColumns; column++) {
					Cell cell = row.getCell(column);

					if (row.getRowNum() > 0) {

						if (row.getCell(0).toString().equals(browser)) {

							rowData.add(objectFrom(workbook, cell).toString());
						}

					}
				}

			}

		}
		System.out.println(rowData);

		System.out.println("**********");
		workbook.close();
		inputStream.close();
		return rowData;
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		String fileName = "TestData/userRegistration.xlsx";
		DataReaderExcel dr = new DataReaderExcel(fileName);
		ArrayList<List<String>> FR = dr.returnDataRows();
		ArrayList<String> rowData = new ArrayList<String>();
		for (int i = 0; i < FR.size(); i++) {
			System.out.println(FR.get(i).get(0));

			// String mode = FR.get(0).get(0);
			switch (FR.get(i).get(0)) {

			case "WindowFirefox":
				rowData.addAll(FR.get(i));
				// System.out.println(FR.get(i));
				break;
			case "LinuxFirefox":
				// System.out.println(FR.get(i));
				rowData.addAll(FR.get(i));
				break;
			case "WindowChrome":
				// System.out.println(FR.get(i));
				rowData.addAll(FR.get(i));
				break;
			case "Iphone6Plus":
				// System.out.println(FR.get(i));
				rowData.addAll(FR.get(i));
				break;
			case "AndriodTablet":
				// System.out.println(FR.get(i));
				rowData.addAll(FR.get(i));
				break;
			case "WindowIE":
				// System.out.println(FR.get(i));
				rowData.addAll(FR.get(i));
				break;
			case "MacFirefox":
				// System.out.println(FR.get(i));
				rowData.addAll(FR.get(i));
				break;
			case "MacSafari":
				// System.out.println(FR.get(i));
				rowData.addAll(FR.get(i));
				break;
			case "MacChrome":
				// System.out.println(FR.get(i));
				rowData.addAll(FR.get(i));
				break;
			case "IpadAir":
				// System.out.println(FR.get(i));
				rowData.addAll(FR.get(i));
				break;
			case "AndriodPhone":
				// System.out.println(FR.get(i));
				rowData.addAll(FR.get(i));
				break;

			}
		}

	}
}
