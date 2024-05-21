package com.JQuery;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sortable {
	
	WebDriver driver;
	String applicationUrlAddress = "https://jqueryui.com/sortable/";
	@BeforeTest
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(applicationUrlAddress);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void sortable() {
		
		By frame = By.cssSelector(".demo-frame");
		WebElement framee=driver.findElement(frame);
		driver.switchTo().frame(framee);
		By sortableProperty = By.cssSelector("[class=\"ui-state-default ui-sortable-handle\"]");
		List<WebElement> sortable=driver.findElements(sortableProperty);
		System.out.println(sortable.size());
		WebElement source=sortable.get(1);
		WebElement destination=sortable.get(5);
		Actions action = new Actions(driver);
		//action.clickAndHold(source).moveToElement(destination).perform();
		//action.clickAndHold(source).moveByOffset(10, 100);
		action.dragAndDrop(source, destination).build().perform();
	}

}
