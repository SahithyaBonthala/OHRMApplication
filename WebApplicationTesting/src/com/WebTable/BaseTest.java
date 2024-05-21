package com.WebTable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	WebDriver driver;
	String applicationUrlAddress = "https://www.timeanddate.com/worldclock/";
	
	@BeforeTest
	public void applicationLaunch()
	{
		
		System.setProperty("webdriver.chrome.driver", "./BrowserDriverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(applicationUrlAddress);
		driver.manage().window().maximize();
		
	}
	@AfterTest
	public void applicationClose()
	{
		driver.close();
	}

}
