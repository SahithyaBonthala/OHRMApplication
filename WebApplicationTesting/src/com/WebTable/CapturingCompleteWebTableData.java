package com.WebTable;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CapturingCompleteWebTableData extends BaseTest {
	
	@Test(priority=1,description=" Capturing Complete WebTable data from World Clock WebTable ")
	public void getting_CompleteWebTableData()
	{
		
		
		///html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody
		By tableProperty = By.tagName("tbody");
		WebElement table = driver.findElement(tableProperty);
		
		By rowProperty = By.tagName("tr");
		List<WebElement>rows = table.findElements(rowProperty);
		
		for(WebElement row : rows)
		{
			By rowOfCellProperty = By.tagName("td");
			List<WebElement> rowOfCells = row.findElements(rowOfCellProperty);
			
			for(WebElement rowOfCell : rowOfCells)
			{
				String tableData = rowOfCell.getText();
				System.out.print(tableData + " | ");
			}
			System.out.println();
			
		}
	}

}
