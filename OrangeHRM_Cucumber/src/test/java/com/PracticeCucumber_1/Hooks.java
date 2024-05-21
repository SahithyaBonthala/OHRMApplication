package com.PracticeCucumber_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Utility.Log;

import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks {
	
	public static WebDriver driver;
	
	@Before
	public void setUp()
	{
		
		System.setProperty("webdriver.chrome.driver", "./ChromeDriver/chromedriver.exe");
		driver= new ChromeDriver();
		Log.info(" ********* Chrome browser launched Successfully *********** ");
	}
	
	@After
	public void tearDown() {
		
		driver.quit();
		Log.info(" ******** Chrome Browser along with the Application closed Successfully *********** ");
	}
	

}
