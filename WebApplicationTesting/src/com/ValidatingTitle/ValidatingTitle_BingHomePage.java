package com.ValidatingTitle;

import org.openqa.selenium.chrome.ChromeDriver;

public class ValidatingTitle_BingHomePage {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");
		ChromeDriver chromeBrowser = new ChromeDriver();

		// Navigating to Bing Application HomePage
		chromeBrowser.get("http://bing.com");

		String expected_BingHomePageTitle="Bing"; // Should Be Bing
		System.out.println(" The Expected Bing Home page Title is :- "+expected_BingHomePageTitle);
		
		/*
		String expected_BingHomePageTitle="bing"; // Should Be Bing
		System.out.println(" The Expected Bing Home page Title is :- "+expected_BingHomePageTitle);
        */
	

		// Of the Current WebPage - identifying the Title
		String actual_WebPageTitle=chromeBrowser.getTitle();
		System.out.println(" The Actual Web page Title is :- "+actual_WebPageTitle);

		if(actual_WebPageTitle.equals(expected_BingHomePageTitle))
		{
		System.out.println(" The Title of the Bing Home Page Matched - PASS");
		}
		else
		{
		System.out.println(" The Title of the Bing Home Page NOT Matched - FAIL");
		}

		//chromeBrowser.close();

	}

}
