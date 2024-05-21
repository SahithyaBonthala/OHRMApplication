package com.OrangeHRMApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.Utility.Log;

public class BaseTest {
	
	public WebDriver driver ;
	
	String applicationUrlAddress = "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";
	
	@BeforeTest
	public void applicationLaunch()
	{
		
		System.setProperty("webdriver.chrome.driver", "./ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		Log.info("**** Chrome Browser Launched Successfully ********** ");
		
		driver.get(applicationUrlAddress);
		Log.info(" Successfully Navigated to OrangeHRM Application LogIn Page ");
		
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void applicationClose()
	{
		driver.quit();
		Log.info(" ************ Chrome Browser along with OrangeHRM Application Closed Successfully ********");
	}

	
	
	
	//*[@id="search"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span
	//html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span
	//<span class="a-size-medium a-color-base a-text-normal">Redmi 12 5G Pastel Blue 4GB RAM 128GB ROM</span>
}
