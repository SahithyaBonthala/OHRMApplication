package com.WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WebTable_FirstRow_FirstRowOfCell_GetCityName extends BaseTest {
	
	@Test
	public void webTable_GetCityName()
	{
		
		By webTableCityNameProperty = By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]");
		WebElement cityName = driver.findElement(webTableCityNameProperty);
		String cityName_Text = cityName.getText();
		System.out.println("The CityName is : - " + cityName_Text);
		
	}

}
