package com.vTiger.Utility;

import java.io.*;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vTiger.BaseClass.BaseClass;

public class testUtil extends BaseClass {
	public static String TestDataSheetPath = "C://Users/nitin1/Desktop/Project Test Data.xlsx";
	public static Workbook book2;
	public static Sheet sheet2;

	public testUtil() {
		super();
	}
	//CAPTURE SCREEN SHOT
	public static void captureFailureScreenshot(String screenshotName) throws Exception{
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File srcFile=screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("G://kayan tech solution/VTigerTest/Screenshots/"+screenshotName+System.currentTimeMillis()+".png"));
	}

	// SYNCRONISATION VERIABLES
	public static long page_load_timeout = 40;
	public static long implicit_wait = 50;

	// MOUSE HOVOUR METHOD UTILITY
	public static void mouseHovourAction(WebElement fromElement, WebElement toElement) {
		Actions action = new Actions(driver);
		action.moveToElement(fromElement);
		action.moveToElement(toElement);
		action.click().build().perform();
	}

	public static void explicitWaitCondition(int timeout, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	// UTILITY METHOD TO GET DATA FRM EXCEL SHEET
	public static Object[][] getData(String fileName, String sheetName) {
		Workbook workbook = null;
		Sheet sheet = null;
		try {

			java.util.List<HashMap<String, String>> allRecords = new ArrayList<HashMap<String, String>>();

			workbook = new XSSFWorkbook(fileName);
			sheet = workbook.getSheet(sheetName);

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				HashMap<String, String> map1 = new HashMap<String, String>();
				map1.put("ProjectName", getValue(sheet, i, 0).toString());
				map1.put("AssignedTo", getValue(sheet, i, 1).toString());
				map1.put("Description", getValue(sheet, i, 2).toString());
				allRecords.add(map1);
			}
			System.out.println("Record found " + allRecords.size());

			Object[][] data = new Object[allRecords.size()][1];
			for (int i = 0; i < allRecords.size(); i++) {
				HashMap<String, String> map = allRecords.get(i);
				data[i][0] = map;
			}
			return data;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
			return null;
		}
	}

	// UTILITY METHOD TO GET EXCEL SHEE
	public static Object getValue(Sheet sheet1, int rowIndex, int coIndex) {
		Object value = null;
		Cell cell = sheet1.getRow(rowIndex).getCell(coIndex);
		switch (cell.getCellTypeEnum()) {
		case STRING:
			value = cell.getStringCellValue();
			break;
		case NUMERIC:
			value = cell.getNumericCellValue();
			break;
		case BOOLEAN:
			value = cell.getBooleanCellValue();
			break;
		case ERROR:
			value = "#ERR";
		default:
			break;
		}
		return value;
	}

	// METHOD OVERLOADING ONLY FOR STRING TEST DATA
	public static Object[][] getData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TestDataSheetPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book2 = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet2 = book2.getSheet(sheetName);
		Object[][] data = new Object[sheet2.getLastRowNum()][sheet2.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet2.getLastRowNum(); i++) {
			for (int k = 0; k < sheet2.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet2.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}
}
