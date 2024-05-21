package com.GetTitle;

import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitle_BingHomePage {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");
		ChromeDriver chromeBrowser = new ChromeDriver();

		// Navigating to Bing Application HomePage
		chromeBrowser.get("http://bing.com");

		// Of the Current WebPage - identifying the Title

		String bingTitle=chromeBrowser.getTitle(); // the identified title is assigned to a variable "bingTitle"

		System.out.println(" The Title of the Bing Current WebPage is :- "+bingTitle);

		chromeBrowser.quit();
		
	}

}
