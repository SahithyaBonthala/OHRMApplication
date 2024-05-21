package com.WebApp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class YouTube {
	
	WebDriver driver;
	
	String applicationUrlAddress = " https://www.youtube.com/ ";
	
	@BeforeTest
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(applicationUrlAddress);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	//@AfterTest
	public void tearDown() {
		
		driver.quit();
	}
	
	@Test
	public void test() throws InterruptedException {
		
		//search-input
		//By searchProperty=By.id("search-input");
		By searchProperty=By.name("search_query");
		WebElement search=driver.findElement(searchProperty);
		//WebDriverWait searchWait = new WebDriverWait(driver, 30);
		//searchWait.until(ExpectedConditions.elementToBeClickable(searchProperty)).click();
		//search.click();
		/*
		Actions keyBoardActions = new Actions(driver);
		keyBoardActions.sendKeys(Keys.TAB).build().perform();
		keyBoardActions.sendKeys(Keys.TAB).build().perform();
		keyBoardActions.sendKeys(Keys.TAB).build().perform();
		keyBoardActions.sendKeys(Keys.TAB).build().perform();
		*/
		search.sendKeys(" Hanuman ");
		//search.sendKeys(" Charlie puth ");
		Actions keyBoardActions = new Actions(driver);
		keyBoardActions.sendKeys(Keys.ENTER).build().perform();
		
		//Thread.sleep(5000);
		WebDriverWait searchWait = new WebDriverWait(driver, 20);
		//searchWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Charlie Puth - Attention [Official Video]']")));
		searchWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Powerful HANUMAN CHALISA from HanuMan | Prasanth Varma | Primeshow Entertainment']")));
		//By songProperty=By.xpath("//*[@className='style-scope ytd-video-renderer']");
		By songProperty=By.xpath("//*[text()='Powerful HANUMAN CHALISA from HanuMan | Prasanth Varma | Primeshow Entertainment']");
		//By songProperty=By.xpath("//*[text()='Charlie Puth - Attention [Official Video]']");

		WebElement song=driver.findElement(songProperty);
		song.click();
		try {
		searchWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Skip']")));

		By skipProperty=By.xpath("//*[text()='Skip']");
		WebElement skip=driver.findElement(skipProperty);
		keyBoardActions.moveToElement(skip).click().build().perform();
		//skip.click();
		
		}
		catch(Exception e) {
			
		}
		By noThanksProperty=By.xpath("//*[text()='No thanks']");
		WebElement noThanks=driver.findElement(noThanksProperty);
		keyBoardActions.moveToElement(noThanks).click().build().perform();
		
	}

}
