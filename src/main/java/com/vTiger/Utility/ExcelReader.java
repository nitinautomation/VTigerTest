package com.vTiger.Utility;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelReader(String path, String sheetName) {
		try {
			workbook = new XSSFWorkbook(path);
			sheet = workbook.getSheet(sheetName);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	public static int getRowCount() {
		int rowCount = 0;
		try {

			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("Number of Rows " + rowCount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return rowCount;
	}

	public static int getColCount() {
		int colCount = 0;
		try {
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Number of Cols " + colCount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return colCount;
	}

	public static String getCellStringData(int rowNum, int colNum) {
		String celData = null;
		try {

			celData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return celData;
	}

	public static double getCellNumbericData(int rowNum, int colNum) {
		double cellData = 0;
		try {
			cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();

		}
		return cellData;
	}

	public static Object[][] testData(String Path, String sheet) {
		ExcelReader excel = new ExcelReader(Path, sheet);
		int rowCount = excel.getRowCount();
		int celCount = excel.getColCount();
		Object[][] data = new Object[rowCount-1][celCount];

		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < celCount; j++) {
				String cellData = excel.getCellStringData(i, j);
				data[i-1][j]= cellData;
			}
			System.out.println();
		}return data;
	}

//	public static void main(String[] args) {
//		testData("G://kayan tech solution/VTigerTestDemo/src/main/java/com/vTiger/TestData/Project Test Data.xlsx",
//				"Project");
//	}

}
