package com.OrangeHRMApplicationTestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.BaseTest.BaseTest;
import com.Utility.Log;

public class EmployeeList extends LogInTest {
	
	@Test(priority=4,description="Validating OrangeHRM Application Home Page PIM Functionality ")
	public void pimTest() {
		
		By pimElementProperty=By.linkText("PIM");
		WebElement pimElementLink=driver.findElement(pimElementProperty);
		
		Actions mouseHoverOperation = new Actions(driver);
		mouseHoverOperation.moveToElement(pimElementLink).build().perform();
	}
	
	@Test(priority=5,description="Printing Employee List To Excel ")
	public void Print_EmployeeList() throws IOException, InterruptedException
	{
	
		By employeeListProperty = By.linkText("Employee List");
		WebElement employeeList = driver.findElement(employeeListProperty);
		employeeList.click();
		
		By employeeListTableProperty = By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table");
		WebElement employeeListTable = driver.findElement(employeeListTableProperty);
		
		By tableHeadProperty = By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/thead/tr");
		WebElement headingsRow = employeeListTable.findElement(tableHeadProperty);
		
		By tableHeadRowOfCellsProperty = By.tagName("th");
		List<WebElement> tableHeadRowOfCells = headingsRow.findElements(tableHeadRowOfCellsProperty);
	    
		//FileInputStream orangeHRM_EmployeeListFile = new FileInputStream("./src/main/java/com/OrangeHRMApplicationTestDataFiles/OrangeHRM_EmployeeList.xlsx");
    	//XSSFWorkbook workBook= new XSSFWorkbook(orangeHRM_EmployeeListFile);
		XSSFSheet employeeListSheet = workBook.getSheet("Sheet3");
		Row newRow=employeeListSheet.createRow(0);
		for(int headerCellIndex=1;headerCellIndex<tableHeadRowOfCells.size();headerCellIndex++)
		{
			
	    	Cell newRowOfCell=newRow.createCell(headerCellIndex-1);
			WebElement cell=tableHeadRowOfCells.get(headerCellIndex);
			String data=cell.getText();
			newRowOfCell.setCellValue(data);
			Log.info(data + " ");
		}
		Log.info(" ");
	
		for(int nextTableIndex=1; nextTableIndex<=5;nextTableIndex++)
		{
		
			
		By employeeListTableBodyProperty = By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody");
		WebElement employeeListTableBody = driver.findElement(employeeListTableProperty);
		By employeeListTableRowProperty = By.tagName("tr");
		List<WebElement>employeeListTableBodyRows = employeeListTableBody.findElements(employeeListTableRowProperty);
		int employeeListTableRows_Count=employeeListTableBodyRows.size();
		Log.info(employeeListTableRows_Count);

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
			Log.info(data + " ");
			}
			Log.info(" ");
			}
		FileOutputStream orangeHRM_EmployeeListResultFile = new FileOutputStream("./src/main/java/com/OrangeHRMApplicationTestResultFiles/OrangeHRM_EmployeeListPage"+nextTableIndex+".xlsx");
		//workBook.write(orangeHRM_EmployeeListResultFile);
		//orangeHRM_EmployeeListResultFile.close();
	
		
		By shiftTableProperty = By.linkText("Next");
		WebElement shiftTable = driver.findElement(shiftTableProperty);
		shiftTable.click();
		
		//Thread.sleep(10000);
		}
		
		
		
		
	}

}




