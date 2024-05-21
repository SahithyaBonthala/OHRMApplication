package com.DatePicker;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Datepicker {
	
	public static void main(String[] args) {
		
	System.setProperty("webdriver.chrome.driver", "./ChromeDriver/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.navigate().to("https://jqueryui.com/datepicker/");
	//scrolling
	By exampleloc=By.xpath("//h2[text()='Examples']");
	WebElement exaample=driver.findElement(exampleloc);
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true)", exaample);
	
	//switch frame
	driver.switchTo().frame(0);
	// click on the textbox
	By textboxL=By.cssSelector("input#datepicker");
	WebElement textbox=driver.findElement(textboxL);
	textbox.click();
	// click next button three times
	for(int i=1;i<=3;i++)
	{
	By nextbton=By.xpath("//span[text()='Next']");
	WebElement textbtunn=driver.findElement(nextbton);
	textbtunn.click();
	}
	By tablebuttonloc=By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td");
	List<WebElement>tablebutton=driver.findElements(tablebuttonloc);
	for(WebElement btn:tablebutton)
	{
		if(btn.getText().equals("15"))
		{
			btn.click();
		}
	}

	}
	}
