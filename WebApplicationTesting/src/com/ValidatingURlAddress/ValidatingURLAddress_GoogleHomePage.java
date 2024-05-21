package com.ValidatingURlAddress;

import org.openqa.selenium.chrome.ChromeDriver;

public class ValidatingURLAddress_GoogleHomePage {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./BrowserDriverFiles/chromedriver.exe");
		ChromeDriver chromeBrowser = new ChromeDriver();
		
		chromeBrowser.get("http://google.com");


		// google.com - should have in the URl Address

		String expected_GoogleHomePageURlAddress="google.com";
		System.out.println(" The Expected Url Address of the Google Home Page is :- "+expected_GoogleHomePageURlAddress);

		// getting the URL Address of the current WebPage
		String actual_googleCurrentWebPageUrlAddress=chromeBrowser.getCurrentUrl();
		System.out.println(" The Actual Current URL Address of the WebPage is :- "+actual_googleCurrentWebPageUrlAddress);

		if(actual_googleCurrentWebPageUrlAddress.contains(expected_GoogleHomePageURlAddress))
		{
		System.out.println(" Successfully Navigated to Google Home Page  - Url Address found - PASS");
		}
		else
		{
		System.out.println(" Failed to navigate Google Home Page  - Url Address NOT found - FAIL");
		}


		chromeBrowser.quit();


	}

}
