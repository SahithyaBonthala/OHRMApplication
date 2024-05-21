package com.OrangeHRM_UserDefined;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
	WebDriver driver;
	
	public void applicationLaunch()
	{
		String applicationUrlAddress = "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";
		System.setProperty("webdriver.chrome.driver", "./BrowserDriverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(applicationUrlAddress);
		
		driver.manage().window().maximize();
	}
	
	public void applicationClose()
	{
		driver.quit();
	}

}
