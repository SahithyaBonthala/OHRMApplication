package com.WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FirstColumn_GetCityNames extends BaseTest{
	
	@Test
	public void firstColumnCityNames()
	{
		
		for(int rowIndex=1; rowIndex<=36; rowIndex++)
		{
			By webTableCityNameProperty = By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[" + rowIndex +"]/td[1]");
			WebElement cityName = driver.findElement(webTableCityNameProperty);
			String cityName_Text = cityName.getText();
			System.out.println(cityName_Text);
		}
	}

}
