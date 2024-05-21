package com.OHRMApplication;

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

public class OrangeHRM_EmployeeList1 extends LogInTest{
	
	 @Test(priority=3)
		public void orangeHRM_Print_EmployeeList() throws IOException
		{
			
	    	FileInputStream orangeHRM_EmployeeListFile = new FileInputStream("./src/com/OrangeHRM_TestDataFile/OrangeHRM_EmployeeList.xlsx");
	    	XSSFWorkbook workBook= new XSSFWorkbook(orangeHRM_EmployeeListFile);
	    	XSSFSheet employeeListSheet = workBook.getSheet("Sheet1");
	    	
			By pimElementProperty=By.linkText("PIM");
			WebElement pimElementLink=driver.findElement(pimElementProperty);
			//pimElementLink.click();
			
			Actions mouseHoverOperation = new Actions(driver);
			mouseHoverOperation.moveToElement(pimElementLink).build().perform();
			
			//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/viewEmployeeList/reset/1" id="menu_pim_viewEmployeeList">Employee List</a>
			///html/body/div[1]/div[3]/div[2]/div/form/div[4]/table
			By employeeListProperty = By.linkText("Employee List");
			WebElement employeeList = driver.findElement(employeeListProperty);
			employeeList.click();
			
			// //*[@id="resultTable"]
			
			By employeeListTableProperty = By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table");
			//By employeeListTableProperty = By.xpath("//*[@id=\"resultTable\"]");
			WebElement employeeListTable = driver.findElement(employeeListTableProperty);
			
			By tableHeadProperty = By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/thead/tr");
			WebElement headingsRow = employeeListTable.findElement(tableHeadProperty);
			
			By tableHeadRowOfCellsProperty = By.tagName("th");
			List<WebElement> tableHeadRowOfCells = headingsRow.findElements(tableHeadRowOfCellsProperty);
			Row newRow=employeeListSheet.createRow(0);
			for(int headerCellIndex=1;headerCellIndex<tableHeadRowOfCells.size();headerCellIndex++)
			{
				//Row newRow=employeeListSheet.createRow(headerCellIndex);
				Cell newRowOfCell=newRow.createCell(headerCellIndex-1);
				WebElement cell=tableHeadRowOfCells.get(headerCellIndex);
				String data=cell.getText();
				newRowOfCell.setCellValue(data);
				System.out.print(data + " ");
			}
			System.out.println();
			
			By employeeListTableRowProperty = By.tagName("tr");
			List<WebElement>employeeListTableRows = employeeListTable.findElements(employeeListTableRowProperty);
			int employeeListTableRows_Count=employeeListTableRows.size();
			System.out.println(employeeListTableRows_Count);
			
			for(int rowIndex=1;rowIndex<employeeListTableRows_Count;rowIndex++)
			{
				newRow=employeeListSheet.createRow(rowIndex);
				WebElement row=employeeListTableRows.get(rowIndex);
				By employeeListTableRowOfCellProperty = By.tagName("td");
				List<WebElement>employeeListTableRowOfCells = row.findElements(employeeListTableRowOfCellProperty);
				int employeeListTableRowOfCells_Count=employeeListTableRowOfCells.size();
				//System.out.println(employeeListTableRowOfCells_Count);
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
			FileOutputStream orangeHRM_EmployeeListResultFile = new FileOutputStream("./src/com/OrangeHRMApplicationTestResultFiles/OrangeHRM_EmployeeList.xlsx");
			workBook.write(orangeHRM_EmployeeListResultFile);
			
		}

}
