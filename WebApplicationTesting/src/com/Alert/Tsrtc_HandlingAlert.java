package com.Alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tsrtc_HandlingAlert {
	
	WebDriver driver;
	
	String ApplicationUrlAddress = "https://www.tsrtconline.in/oprs-web/";
	
	@BeforeTest
	public void setUp()
	{
		
		System.setProperty("webdriver.chrome.driver","./browserDriverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(ApplicationUrlAddress);
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void tearDown()
	{
		
		driver.quit();
	}
	
	
	@Test
	public void handlingAlert() throws InterruptedException
	{
		
		By checkAvailabilityProperty = By.id("searchBtn");
		WebElement checkAvailability = driver.findElement(checkAvailabilityProperty);
		checkAvailability.click();
		
		Thread.sleep(1000);
		
		Alert tsrtcAlert = driver.switchTo().alert();
		
		String expected_AlertWindowTextMessage = " Please select start place";
		System.out.println(" The Expected Alert Message is: - " + expected_AlertWindowTextMessage);
		
		String actual_AlertWindowTextmessage = tsrtcAlert.getText();
		System.out.println(" The Actual Alert message is : - " + actual_AlertWindowTextmessage);
		
		if(actual_AlertWindowTextmessage.equals(expected_AlertWindowTextMessage))
		{
			System.out.println(" Message Existing - PASS");
		}
		else
		{
			System.out.println(" NO Message Existing - FAIL");
		}
		
		tsrtcAlert.accept();
			
	}

}
