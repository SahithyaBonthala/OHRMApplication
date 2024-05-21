package com.ScreenShot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.ScreenshotException;



public class Bing_HomePage_Captuting_ScreenShot {
	
	
	public static void main(String[] args) throws IOException {
		
		
		String applicationURLAddress="http://bing.com";
		
		System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		driver.get(applicationURLAddress);
		
		File webPageScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(webPageScreenShot, new File("./ApplicationScreenShots/Screenshot.png"));
		
		
		
		
	}

}
