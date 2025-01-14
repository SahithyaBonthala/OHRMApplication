package com.RadioButtons;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RadioButtons {
	
	WebDriver driver;
		String applicationUrl = "https://echoecho.com/htmlforms10.htm";
	
		@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "./ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(applicationUrl);
		driver.manage().window().maximize();
	}
		
	public void tearDown() {
		
		driver.close();
	}
 
	@Test
	public void main() {
		
		By buttonProperty = By.name("group1");
		List <WebElement> radioButtons = driver.findElements(buttonProperty);
		int buttonsCount = radioButtons.size();
		
		for(int click=0; click<buttonsCount;click++) {
			
			String radioButtonsName = radioButtons.get(click).getAttribute("value");
			System.out.println(radioButtonsName);
			radioButtons.get(click).click();
			
		}
		
	}
}
