package com.StepDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Utility.Log;

import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks {
	
	public static WebDriver driver;
	
	@Before
	public static void SetUp()
	{
		
		System.setProperty("webdriver.chrome.driver", "./ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		Log.info(" ***** Chrome Browser Launched Successfully ****");
		
	}
	
	@After
	public static void tearDown() {
		
		driver.quit();
		Log.info(" *** Browser closed with application successfully ***********");
	}

}
