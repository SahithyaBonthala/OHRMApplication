package com.MouseHoverOperation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon_HelloSignIn_MouseHoverOperation {
	
	public static void main(String[] args) {
		
		WebDriver driver;
		String applicationUrlAddress="http://amazon.in";
		System.setProperty("webdriver.chrome.driver", "./BrowserDriverFiles/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get(applicationUrlAddress);
		
		//<span id="nav-link-accountList-nav-line-1" class="nav-line-1 nav-progressive-content">Hello, sign in</span>
		
		By signInProperty=By.id("nav-link-accountList-nav-line-1");
		WebElement helloSignIn=driver.findElement(signInProperty);
		
		Actions mouseHoverOperation = new Actions(driver);
		mouseHoverOperation.moveToElement(helloSignIn).build().perform();
		
	}

}
