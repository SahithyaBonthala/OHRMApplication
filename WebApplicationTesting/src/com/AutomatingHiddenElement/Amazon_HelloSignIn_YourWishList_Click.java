package com.AutomatingHiddenElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon_HelloSignIn_YourWishList_Click {
	
	public static void main(String[] args) {
		
		WebDriver driver ;
		 
		String applicationUrlAddress = "http://amazon.in";
		System.setProperty("webdriver.chrome.driver", "./BrowserDriverFiles/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get(applicationUrlAddress);
		
		By signInProperty=By.id("nav-link-accountList-nav-line-1");
		WebElement helloSignIn=driver.findElement(signInProperty);
		
		Actions mouseHoverOperation = new Actions(driver);
		mouseHoverOperation.moveToElement(helloSignIn).build().perform();
		
		//<span class="nav-text">Your Wish List</span>
		
		By yourWishListProperty=By.linkText("Your Wish List");
		WebElement yourWishList=driver.findElement(yourWishListProperty);
		 
		yourWishList.click();
		
		String yourWishListPageTitle=driver.getTitle();
		System.out.println(yourWishListPageTitle);
		driver.quit();
  }

}
