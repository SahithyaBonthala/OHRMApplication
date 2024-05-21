package com.OrangeHRMApplication;

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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Excel_OrangeHRMCompleteEmployeeList extends OrangeHRM_ApplicationTest {
	
	@Test(priority=4)
	public void orangeHRM_Print_EmployeeList() throws IOException, InterruptedException
	{
	
		By pimElementProperty=By.linkText("PIM");
		WebElement pimElementLink=driver.findElement(pimElementProperty);
		
		Actions mouseHoverOperation = new Actions(driver);
		mouseHoverOperation.moveToElement(pimElementLink).build().perform();
		
		By employeeListProperty = By.linkText("Employee List");
		WebElement employeeList = driver.findElement(employeeListProperty);
		employeeList.click();
		
		By employeeListTableProperty = By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table");
		WebElement employeeListTable = driver.findElement(employeeListTableProperty);
		
		By tableHeadProperty = By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/thead/tr");
		WebElement headingsRow = employeeListTable.findElement(tableHeadProperty);
		
		By tableHeadRowOfCellsProperty = By.tagName("th");
		List<WebElement> tableHeadRowOfCells = headingsRow.findElements(tableHeadRowOfCellsProperty);
	    
		FileInputStream orangeHRM_EmployeeListFile = new FileInputStream("./src/com/OrangeHRM_TestDataFile/OrangeHRM_EmployeeList.xlsx");
    	XSSFWorkbook workBook= new XSSFWorkbook(orangeHRM_EmployeeListFile);
    	XSSFSheet employeeListSheet = workBook.getSheet("Sheet1");
		Row newRow=employeeListSheet.createRow(0);
		for(int headerCellIndex=1;headerCellIndex<tableHeadRowOfCells.size();headerCellIndex++)
		{
			
	    	Cell newRowOfCell=newRow.createCell(headerCellIndex-1);
			WebElement cell=tableHeadRowOfCells.get(headerCellIndex);
			String data=cell.getText();
			newRowOfCell.setCellValue(data);
			System.out.print(data + " ");
		}
		System.out.println();
	
		for(int nextTableIndex=1; nextTableIndex<5;nextTableIndex++)
		{
		
			
		By employeeListTableBodyProperty = By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody");
		WebElement employeeListTableBody = driver.findElement(employeeListTableProperty);
		By employeeListTableRowProperty = By.tagName("tr");
		List<WebElement>employeeListTableBodyRows = employeeListTableBody.findElements(employeeListTableRowProperty);
		int employeeListTableRows_Count=employeeListTableBodyRows.size();
		System.out.println(employeeListTableRows_Count);

		for(int rowIndex=1;rowIndex<employeeListTableRows_Count;rowIndex++)
		{
			
			newRow=employeeListSheet.createRow(rowIndex);
			
			WebElement row=employeeListTableBodyRows.get(rowIndex);
			By employeeListTableRowOfCellProperty = By.tagName("td");
			List<WebElement>employeeListTableRowOfCells = row.findElements(employeeListTableRowOfCellProperty);
			int employeeListTableRowOfCells_Count=employeeListTableRowOfCells.size();
		
			for(int rowOfCellIndex=1;rowOfCellIndex<employeeListTableRowOfCells_Count;rowOfCellIndex++)
			{
				
				Cell newRowOfCell=newRow.createCell(rowOfCellIndex-1);	
			WebElement cell=employeeListTableRowOfCells.get(rowOfCellIndex);
			String data=cell.getText();
			newRowOfCell.setCellValue(data);
			System.out.print(data + " ");
			}
			System.out.println();
			}
		FileOutputStream orangeHRM_EmployeeListResultFile = new FileOutputStream("./src/com/OrangeHRMApplicationTestResultFiles/OrangeHRM_EmployeeList"+nextTableIndex+"Page.xlsx");
		workBook.write(orangeHRM_EmployeeListResultFile);
		
		By shiftTableProperty = By.linkText("Next");
		WebElement shiftTable = driver.findElement(shiftTableProperty);
		shiftTable.click();
		
		//Thread.sleep(10000);
		}
		
		
		
		
	}

}
