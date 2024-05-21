package com.WebTable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class WebTable_FirstColumnData_ExportToExcel extends BaseTest {
	
	@Test
	public void excel_ExportFirstColumnData() throws IOException
	{
		
		FileInputStream webTableFile = new FileInputStream("./src/com/WebTableExcel/Excel_WebTableData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(webTableFile);
		XSSFSheet dataSheet = workBook.getSheet("Sheet2");
		
		for(int rowIndex=1;rowIndex<=36;rowIndex++)
		{
		
		Row newRow=dataSheet.createRow(rowIndex-1);
		By WebTableCityNameProperty = By.xpath(" /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+rowIndex+"]/td[1]");
		WebElement webTableCityName = driver.findElement(WebTableCityNameProperty);
		String cityName=webTableCityName.getText();
		Cell newRowOfCell=newRow.createCell(0);
		newRowOfCell.setCellValue(cityName);
		System.out.println(cityName + " ");
		
		FileOutputStream webTableResultFile = new FileOutputStream("./src/com/WebTableExcel/Excel_WebTableData.xlsx");
		workBook.write(webTableResultFile);
		
		}
		
	}

}
