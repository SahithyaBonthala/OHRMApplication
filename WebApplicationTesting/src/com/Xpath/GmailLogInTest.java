package com.Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Utility.Log;

public class GmailLogInTest {
	
	WebDriver driver;
	
	String applicationUrlAddress = "http://gmail.com";
	
	@BeforeTest
	public void applicationLaunch() {
		
		System.setProperty("webdriver.chrome.driver", "./BrowserDriverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		Log.info("**** Chrome Browser Launched Successfully ********** ");
		
		driver.get(applicationUrlAddress);
		
		Log.info(" Successfully Navigated to GMail Application LogIn Page ");
		
		driver.manage().window().maximize();
		 
	}
	
	//@AfterTest
	public void applicationClose() {
		
		driver.quit();
		Log.info(" ***  Chrome Browser along with GMail Application Closed Successfully ***** ");
	}
	
	@Test
	public void LogInTest() {
		
		By emailIdProperty=By.xpath("//*[@aria-label='Email or phone']");
		WebElement emailId=driver.findElement(emailIdProperty);
		emailId.sendKeys("sahithyabonthala@gmail.com");
		
		 //By nextButtonProperty=By.className("VfPpkd-RLmnJb");
		By nextButtonProperty=By.xpath("//*[text()='Next']");
		 WebElement nextButton=driver.findElement(nextButtonProperty);
		 nextButton.click();

	}

}
