package com.WindowsHandling;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Windows {
	
	WebDriver driver;
	String applicationUrl = "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	@BeforeTest
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.get(applicationUrl);
		}
	@Test
	public void test() throws IOException, InterruptedException {
		String windowID=driver.getWindowHandle();
		System.out.println(windowID);
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		
		
		Set<String> WindowIDs=driver.getWindowHandles();
		Iterator<String> IDs = WindowIDs.iterator();
		String parentWin=IDs.next();
		String childWin=IDs.next();
		driver.switchTo().window(parentWin);
		WebElement image=driver.findElement(By.xpath("//img[@src='/orangehrm-4.2.0.1/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/login/logo.png']"));
		File ss = image.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss, new File("C:\\Users\\HP\\OneDrive\\Desktop\\OrangeHRM\\WebApplicationTesting\\ApplicationScreenShots\\Parent.png"));
		System.out.println(driver.getTitle());
		driver.switchTo().window(childWin);
		JavascriptExecutor js = (JavascriptExecutor)driver;		
		WebElement image1=driver.findElement(By.xpath("//img[@src='/assets/Uploads/OrangeHRM_Logo.svg']"));
		js.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(5000);
		File ss1 = image1.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss1, new File("C:\\Users\\HP\\OneDrive\\Desktop\\OrangeHRM\\WebApplicationTesting\\ApplicationScreenShots\\Child.png"));
		System.out.println(driver.getTitle());
		
		for(String win:WindowIDs) {
			
			String title = driver.switchTo().window(win).getTitle();
			System.out.println(title);
			
		}
	}
	
	
}
