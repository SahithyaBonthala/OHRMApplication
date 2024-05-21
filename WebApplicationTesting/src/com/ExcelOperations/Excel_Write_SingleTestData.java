package com.ExcelOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Write_SingleTestData {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream testDataFile = new FileInputStream("./src/com/Excell/WorkBook.xlsx");
		
		XSSFWorkbook workBook = new XSSFWorkbook(testDataFile);
		
		XSSFSheet testDataSheet =  workBook.getSheet("TestDataSheet");
		
		Row newRow = testDataSheet.createRow(5);
		
		Cell newRowOfNewCell = newRow.createCell(6);
		
		newRowOfNewCell.setCellValue("WebDriver");
		
		FileOutputStream testDataResultFile = new FileOutputStream("./src/com/Excell/WorkBook.xlsx");
		workBook.write(testDataResultFile);
		
		
	}

}
