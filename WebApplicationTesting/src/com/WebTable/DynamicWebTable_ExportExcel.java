package com.WebTable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;



public class DynamicWebTable_ExportExcel extends BaseTest {
	
	@Test
	public void excel_ExportWebTable() throws IOException
	{
		
		FileInputStream webTableFile= new FileInputStream("./src/com/WebTableExcel/Excel_WebTableData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(webTableFile);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		By webTableProperty = By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table");
		WebElement webTable = driver.findElement(webTableProperty);
		
		By webTableRowProperty = By.tagName("tr");
		List<WebElement>webTableRows=webTable.findElements(webTableRowProperty);
		int rowCount=webTableRows.size();		
		
		for(int rowIndex=1; rowIndex<rowCount; rowIndex++)
		{
			Row newRow=sheet.createRow(rowIndex-1);
			WebElement row=webTableRows.get(rowIndex);
			By webTableRowOfCellProperty = By.tagName("td");
			List<WebElement>webTableRowOfCells=row.findElements(webTableRowOfCellProperty);
			
			for(int rowOfCellIndex=0; rowOfCellIndex<webTableRowOfCells.size();rowOfCellIndex++)
			{
				Cell newRowOfCell=newRow.createCell(rowOfCellIndex);
				WebElement rowOfCell=webTableRowOfCells.get(rowOfCellIndex);
				String data=rowOfCell.getText();
				newRowOfCell.setCellValue(data);
				System.out.print(data + " | ");
				
			}
			System.out.println();
		}
		FileOutputStream webTableResultFile = new FileOutputStream("./src/com/WebTableExcel/Excel_WebTableData.xlsx");
		workbook.write(webTableResultFile);
	}

}
