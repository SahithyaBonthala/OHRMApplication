package com.WaitConcept;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	WebDriver driver;
	
	String applicationUrlAddress = "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";
	
	@BeforeTest
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(applicationUrlAddress);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	@AfterTest
    public void tearDown() {
    	
    	driver.quit();
    }
}
