package com.WindowsHandling;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM {
	
	public static void main(String[] args) throws IOException {
		
	WebDriver driver = new ChromeDriver();
	
	driver.get("http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login");
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get("https://www.instagram.com/");
	WebElement portion=driver.findElement(By.xpath("//img[@src='/images/instagram/xig/homepage/screenshots/screenshot4.png?__d=www']"));
	File f=portion.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(f, new File("C:\\Users\\HP\\OneDrive\\Desktop\\OrangeHRM\\WebApplicationTesting\\ApplicationScreenShots.png"));
	
	WebElement img=driver.findElement(By.xpath("//img[@class='_aa5q']"));
	//WebElement img=driver.findElement(By.className("_aa5q"));
	File i=img.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(i, new File("C:\\\\Users\\\\HP\\\\OneDrive\\\\Desktop\\\\OrangeHRM\\\\WebApplicationTesting\\\\ApplicationScreenShots\\\\insta.png"));
	driver.switchTo().newWindow(WindowType.WINDOW);
	driver.get("https://google.com");
	driver.navigate().to("https://www.instagram.com/");
	
	}

}
