package com.Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Utility.Log;

public class FacebookLogInTest {
	
	WebDriver driver;
	
	String applicationUrlAddress = "http://facebook.com";
	
	@BeforeTest
	public void applicationLaunch()
	{
		
		System.setProperty("webdriver.chrome.driver", "./BrowserDriverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		Log.info("**** Chrome Browser Launched Successfully ********** ");
		
		driver.get(applicationUrlAddress);
		
		Log.info(" Successfully Navigated to FaceBook Application LogIn Page ");
		
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void applicationClose() {
		
		driver.quit();
		Log.info(" ***  Chrome Browser along with FaceBook Application Closed Successfully ***** ");
	}
	
	@Test
	public void  loginTest()
	{
		//By emailIdProperty=By.xpath("//input[@aria-label='Email address or phone number']");
		//By emailIdProperty=By.xpath("//input[@data-testid='royal_email']");
		By emailIdProperty=By.xpath("//*[@data-testid='royal_email']");
		WebElement emailId=driver.findElement(emailIdProperty);
		emailId.sendKeys("8185993333");
		
		//By passwordProperty=By.xpath("//input[@type='password']");
		//By passwordProperty=By.xpath("//*[@type='password']");
		By passwordProperty=By.xpath("//input[@data-testid='royal_pass' and @name='pass']");
		WebElement password=driver.findElement(passwordProperty);
		password.sendKeys("laddu");
		
		By logInButtonProperty=By.xpath("//*[@data-testid='royal_login_button']");
		WebElement logInButton=driver.findElement(logInButtonProperty);
		logInButton.click();
	}

}
