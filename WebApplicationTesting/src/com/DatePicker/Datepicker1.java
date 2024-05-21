package com.DatePicker;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Datepicker1 {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./ChromeDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/datepicker/");
		
		String exp_year = "2022";
		String exp_month = "February";
		String date = "10";
		
		By frame = By.cssSelector(".demo-frame");
		WebElement framee=driver.findElement(frame);
		driver.switchTo().frame(framee);
		driver.findElement(By.cssSelector("#datepicker")).click();
		
		while(true) {
			WebElement ele =driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span")); 
			String act_Month=ele.getText();
			
			String act_year=driver.findElement(By.cssSelector("[class=\"ui-datepicker-year\"]")).getText();
			if(act_Month.equals(exp_month) && act_year.equals(exp_year)) {
				break;
			}
			else {
				driver.findElement(By.cssSelector("[class=\"ui-icon ui-icon-circle-triangle-w\"]")).click();
			}
		}
		driver.findElement(By.linkText(date)).click();
	}

}
