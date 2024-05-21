package com.ExcelOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Excel_Read_MultipleTestData {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream testDataFile = new FileInputStream("./src/com/Excell/Multiple_TestData.xlsx");

		XSSFWorkbook workBook = new XSSFWorkbook(testDataFile);

		XSSFSheet testDataSheet = workBook.getSheet("Sheet1");


		// Identifying the Number of Active Rows with the Test data in the Sheet
		int rowCount=testDataSheet.getLastRowNum();

		// To goto all the Active Rows in the Sheet
		for(int rowIndex=0;rowIndex<=rowCount;rowIndex++)
		{

		// going to an active Row in the Sheet
		Row testDataSheetRow=testDataSheet.getRow(rowIndex);

		// Going to an Active Row and finding the number of Active Row of its Cells
	
		int testDataRowOfCellsCount=testDataSheetRow.getLastCellNum();

		// To goto every Row of Its Respective Row of Cells
		for(int rowOfCellIndex=0;rowOfCellIndex<testDataRowOfCellsCount;rowOfCellIndex++)
		{
		// Going to an active row of Cell
		Cell rowOfCell=testDataSheetRow.getCell(rowOfCellIndex);

		// get the Row of a Cell value
		String testData=rowOfCell.getStringCellValue();

		System.out.print(testData+" ");
		}

		System.out.println();

	}

}
}
