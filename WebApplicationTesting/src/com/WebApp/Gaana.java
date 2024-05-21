package com.WebApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Gaana {
	public static void main(String[] args) {
		
	
	 
	WebDriver driver;
	
		String applicationUrlAddress = "https://gaana.com/";
		System.setProperty("webdriver.chrome.driver", "./ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(applicationUrlAddress);
	///html/body/div[1]/header/div/div[2]/button
		////*[@id="app"]/header/div/div[2]/button
		By searchProperty=By.xpath("/html/body/div[1]/header/div/div[2]/button");
		WebElement search=driver.findElement(searchProperty);
		////*[@id="app"]/header/div/div[1]/div[4]/section/div[1]/div/input
		By searchProperty1=By.xpath("//*[@id=\"app\"]/header/div/div[1]/div[4]/section/div[1]/div/input");
		WebElement search1=search.findElement(searchProperty);
		System.out.println(search.getText());
		//search.click();
		Actions mouse = new Actions(driver);
		//mouse.moveToElement(search).click();
		search1.sendKeys("orange");
	}

}
