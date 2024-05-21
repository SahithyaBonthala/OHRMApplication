package com.getUrl;

import org.openqa.selenium.chrome.ChromeDriver;

public class GetURl_GoogleHomePage {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./BrowserDriverFiles/chromedriver.exe");
		ChromeDriver chromeBrowser = new ChromeDriver();
		
		chromeBrowser.get("http://google.com");
		
		String googleCurrentWebPageUrlAddress=chromeBrowser.getCurrentUrl();

		System.out.println(" The Current URL Address of the WebPage is :- "+googleCurrentWebPageUrlAddress);

		chromeBrowser.quit();
		
	}

}
