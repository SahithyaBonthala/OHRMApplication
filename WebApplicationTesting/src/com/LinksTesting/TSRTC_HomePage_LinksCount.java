package com.LinksTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TSRTC_HomePage_LinksCount {
	
	public static void main(String[] args) {
		
		String applicationUrlAddress="https://www.tsrtconline.in/oprs-web/";

		System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");
		// ChromeDriver driver = new ChromeDriver();

		WebDriver driver = new ChromeDriver();

		driver.get(applicationUrlAddress);

		
		By linksProperty=By.tagName("a");
		
		List<WebElement>tsrtcApplicationHomePageLinks=driver.findElements(linksProperty);

		int tsrtcApplicationHomePageLinks_Count=tsrtcApplicationHomePageLinks.size();

		System.out.println(" The number of WebElements which are of type links on the TSRTC Application HomePage is :- "+tsrtcApplicationHomePageLinks_Count);

		driver.quit();


		
	}

}
