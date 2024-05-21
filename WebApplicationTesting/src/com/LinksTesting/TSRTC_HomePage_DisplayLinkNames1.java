package com.LinksTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TSRTC_HomePage_DisplayLinkNames1 {
	
	public static void main(String[] args) {
		
		String applicationUrlAddress="https://www.tsrtconline.in/oprs-web/";

		System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get(applicationUrlAddress);
		
		//<div class="menu">
		
         By linksProperty=By.className("menu");        
         WebElement tsrtcApplicationHeaderElement = driver.findElement(linksProperty);
         
		// WebElement tsrtcApplicationHeaderElement = driver.findElement(By.className("menu"));
		 List<WebElement> tsrtcApplicationHeaderLinks = tsrtcApplicationHeaderElement.findElements(By.tagName("a"));



		int tsrtcApplicationHeaderLinks_Count=tsrtcApplicationHeaderLinks.size();

		System.out.println(" The number of WebElements which are of type links on the TSRTC Application HomePage is :- "+tsrtcApplicationHeaderLinks_Count);

		for(int arrayIndex=0;arrayIndex<tsrtcApplicationHeaderLinks_Count;arrayIndex++)
		{
		String tsrtcHeader_LinkName=tsrtcApplicationHeaderLinks.get(arrayIndex).getText();
		System.out.println(arrayIndex+" - "+tsrtcHeader_LinkName);

		}

		
		driver.quit();

	}

}
