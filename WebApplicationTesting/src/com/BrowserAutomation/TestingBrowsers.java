package com.BrowserAutomation;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




public class TestingBrowsers {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.edge.driver", ".\\BrowserDriverFiles\\msedgedriver.exe");

		EdgeDriver edgeBrowser = new EdgeDriver();
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\OneDrive\\Desktop\\New folder\\WebApplicationTesting\\BrowserDriverFiles\\chromedriver.exe");

		// Class     object
		ChromeDriver chromeBrowser = new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\HP\\OneDrive\\Desktop\\New folder\\WebApplicationTesting\\BrowserDriverFiles\\geckodriver.exe");

		FirefoxDriver firefoxBrowser = new FirefoxDriver();
		
		System.setProperty("webdriver.opera.driver", "./BrowserDriverFiles/operadriver1.exe");

		//OperaDriver operaBrowser = new OperaDriver();

		
	}

}
