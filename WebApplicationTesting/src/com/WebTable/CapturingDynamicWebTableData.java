package com.WebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CapturingDynamicWebTableData extends BaseTest {
	
	@Test
	public void getData_DynamicWebTable()
	{
		
		///html/body/div[5]/section[1]/div/section/div[1]/div/table
		
		By webTableProperty = By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table");
		WebElement webTable = driver.findElement(webTableProperty);
		
		By webTableRowProperty = By.tagName("tr");
		List<WebElement>webTableRows=webTable.findElements(webTableRowProperty);
		int rowCount=webTableRows.size();		
		
		for(int rowIndex=1; rowIndex<rowCount; rowIndex++)
		{
			
			WebElement row=webTableRows.get(rowIndex);
			By webTableRowOfCellProperty = By.tagName("td");
			List<WebElement>webTableRowOfCells=row.findElements(webTableRowOfCellProperty);
			
			for(int rowOfCellIndex=0; rowOfCellIndex<webTableRowOfCells.size();rowOfCellIndex++)
			{
				WebElement rowOfCell=webTableRowOfCells.get(rowOfCellIndex);
				String data=rowOfCell.getText();
				System.out.print(data + " | ");
			}
			System.out.println();
		}
		
	}

}
