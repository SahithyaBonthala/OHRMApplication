package com.LinksTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {
	
	public static void main(String[] args) {
		
		String applicationUrlAddress="https://www.tsrtconline.in/oprs-web/";

		System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");
		// ChromeDriver driver = new ChromeDriver();

		WebDriver driver = new ChromeDriver();

		driver.get(applicationUrlAddress);
		
		//By linksProperty=By.className("menu");
		//List<WebElement>tsrtcApplicationHomePageLinks=driver.findElements(linksProperty);

		/*
		<div class="menu">
		
</div>

*/
		 WebElement headerElement = driver.findElement(By.className("menu"));
		 List<WebElement> headerLinks = headerElement.findElements(By.tagName("a"));



		int tsrtcApplicationHomePageLinks_Count=headerLinks.size();

		System.out.println(" The number of WebElements which are of type links on the TSRTC Application HomePage is :- "+tsrtcApplicationHomePageLinks_Count);

		for(int arrayIndex=0;arrayIndex<tsrtcApplicationHomePageLinks_Count;arrayIndex++)
		{
		String tsrtcHomePage_LinkName=headerLinks.get(arrayIndex).getText();
		System.out.println(arrayIndex+" - "+tsrtcHomePage_LinkName);

		}

		
		driver.quit();

	}

}
