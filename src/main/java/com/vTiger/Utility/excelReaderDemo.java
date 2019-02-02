package com.vTiger.Utility;

public class excelReaderDemo {
	
	public static void main(String[] args) {
		ExcelReader excel = new ExcelReader("G://kayan tech solution/VTigerTestDemo/src/main/java/com/vTiger/TestData/Project Test Data.xlsx", "Project");
		excel.getRowCount();
		excel.getCellNumbericData(1, 1);
		excel.getCellStringData(2, 2);
	}
	
}
