package com.TSRTC_HeaderLink_Capturing;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {
	
	public static void main(String[] args) throws IOException {
		
WebDriver driver;
		
		String applicationUrlAddress=("https://www.tsrtconline.in/oprs-web/");
		
		System.setProperty("webdriver.chrome.driver", "./ChromeDriver/chromedriver.exe");
		//WebDriver driver= new ChromeDriver();
		
		driver= new ChromeDriver();
		
		driver.get(applicationUrlAddress);
		
		By headerLinkProperty=By.className("menu-wrap");
		WebElement tsrtc_HeaderLinksBlock=driver.findElement(headerLinkProperty);
		
		By tsrtc_HeaderLinkProperty=By.tagName("a");
		List<WebElement>tsrtc_HeaderLinks= tsrtc_HeaderLinksBlock.findElements(tsrtc_HeaderLinkProperty);
		
		int tsrtc_HeaderLinks_Count=tsrtc_HeaderLinks.size();
		
		System.out.println(tsrtc_HeaderLinks_Count);
		
		for(int arrayIndex=0;arrayIndex<tsrtc_HeaderLinks_Count;arrayIndex++)
		{
			String tsrtc_HeaderLinkName=tsrtc_HeaderLinks.get(arrayIndex).getText();
			System.out.println(arrayIndex + "-" + tsrtc_HeaderLinkName);
			
			tsrtc_HeaderLinks.get(arrayIndex).click();
			//tsrtc_HeaderBlocklinks.get(arrayIndex).click();
			
			String webPageTitle=driver.getTitle();
			System.out.println(webPageTitle);

			String webPageUrlAddress=driver.getCurrentUrl();
			System.out.println(webPageUrlAddress);
			File webPageScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(webPageScreenShot, new File("C:\\Users\\HP\\OneDrive\\Desktop\\New folder\\WebApplicationTesting\\ApplicationScreenShots\\"+tsrtc_HeaderLinkName+".png"));
			//FileUtils.copyFile(webPageScreenShot, new File("C:\\Users\\HP\\OneDrive\\Desktop\\New folder\\WebApplicationTesting\\ApplicationScreenShotsScreenshot.png"));
			
			
			
			System.out.println();
			
			driver.navigate().refresh();
			//driver.navigate().back();
			
			tsrtc_HeaderLinksBlock=driver.findElement(headerLinkProperty);
			tsrtc_HeaderLinks=tsrtc_HeaderLinksBlock.findElements(tsrtc_HeaderLinkProperty);
			
		   
		}
		
	}
	

}
