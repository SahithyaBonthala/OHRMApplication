package com.BaseTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.Utility.Log;



public class BaseTest {
	
	public static WebDriver driver;
	
	String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";
	
	@BeforeTest
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		Log.info(" **** Chrome Browser launched Successfully ***** ");
		
		driver.get(applicationUrlAddress);
		
		Log.info(" *** Successfully navigated to orangeHRM Applicaton LogIn Page ******** ");
		
	
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.quit();
		Log.info(" **** Chrome Browser Along With OrangeHRM Application Closed Successfully ******** ");
	}

}
