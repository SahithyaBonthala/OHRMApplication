
package com.LinksTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TSRTC_HeaderBlock_LinksTesting {
	
	public static void main(String[] args) {
		
		WebDriver driver;
		
		String applicationUrlAddress=("https://www.tsrtconline.in/oprs-web/");
		
		System.setProperty("webdriver.chrome.driver", "./BrowserDriverFiles/chromedriver.exe");
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
			
			
			System.out.println();
			
			driver.navigate().refresh();
			//driver.navigate().back();
			
			tsrtc_HeaderLinksBlock=driver.findElement(headerLinkProperty);
			tsrtc_HeaderLinks=tsrtc_HeaderLinksBlock.findElements(tsrtc_HeaderLinkProperty);

		}
		
		driver.quit();
		
		
		
		
	}

}
