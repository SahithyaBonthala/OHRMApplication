package com.ExcelOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Read_SingleTestData {
	public static void main(String[] args) throws IOException {
		
		// Identify the file in the System
		FileInputStream testDataFile = new FileInputStream("./src/com/Excell/WorkBook.xlsx");

		// Identify the workBook in the File
		XSSFWorkbook workBook = new XSSFWorkbook(testDataFile);

		 // Identify the Sheet in the WorkBook
		XSSFSheet testDataSheet = workBook.getSheet("TestDataSheet");

		// Identify a Particular Row in the Sheet
		Row testDataSheetRow=testDataSheet.getRow(2);

		// Identify a Particular Row of a Cell in the Row
		Cell testDataRowOfCell=testDataSheetRow.getCell(2);

		// Get the Test data from the Row Of Cell
		String testData=testDataRowOfCell.getStringCellValue();

		System.out.println(testData);

	}

}
