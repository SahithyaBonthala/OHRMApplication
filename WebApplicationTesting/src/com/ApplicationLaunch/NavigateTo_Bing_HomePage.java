package com.ApplicationLaunch;

import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateTo_Bing_HomePage {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");
		ChromeDriver chromeBrowser = new ChromeDriver();

		// Navigating to Bing Application HomePage
		chromeBrowser.get("http://bing.com");
		
		chromeBrowser.get("http://flipkart.com");
		
		chromeBrowser.navigate().to("http://bing.com"); // will open in the same browser of the same tab

		chromeBrowser.get("http://google.com");
		
		//chromeBrowser.close();
		
		//chromeBrowser.quit();
		
		

	}

}
