package com.LinksTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TSRTC_HomePage_DisplayLinkNames {
	
	public static void main(String[] args) {
		
		String applicationUrlAddress="https://www.tsrtconline.in/oprs-web/";
		
		System.setProperty("webdriver.chrome.driver","./BrowserDriverFiles/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get(applicationUrlAddress);
		
		List<WebElement>tsrtcApplicationLinks=driver.findElements(By.tagName("a"));
		
		int tsrtcApplicationLinks_Count=tsrtcApplicationLinks.size();
		System.out.println("The Total number of Links present in TSRTC Application : - " + tsrtcApplicationLinks_Count);
		
		for(int index=0;index<tsrtcApplicationLinks_Count;index++)
		{
			String tsrtcApplication_LinkName=tsrtcApplicationLinks.get(index).getText();
			System.out.println(index + "-" + tsrtcApplication_LinkName);
		}
		
		
	}

}
