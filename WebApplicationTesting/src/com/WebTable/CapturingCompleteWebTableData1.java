package com.WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CapturingCompleteWebTableData1 extends BaseTest {
	
	@Test
	public void getting_CompleteWebTableData()
	{
		
		for(int rowIndex=1; rowIndex<=36; rowIndex++)
		{
			for(int rowOfCell=1; rowOfCell<=8; rowOfCell++)
			{
			By webTableCityNameProperty = By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[" + rowIndex +"]/td["+ rowOfCell+"]");
			WebElement cityName = driver.findElement(webTableCityNameProperty);
			String cityName_Text = cityName.getText();
			System.out.print(cityName_Text + " | ");
			}
			System.out.println();
		}
	}

}
