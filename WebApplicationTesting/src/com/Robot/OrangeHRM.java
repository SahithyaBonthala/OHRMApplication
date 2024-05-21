package com.Robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OrangeHRM {
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/pim/viewEmployeeList");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Sahithya");
		 
		driver.findElement(By.name("txtPassword")).sendKeys("Sahithy@24");
		 
		driver.findElement(By.className("button")).click();
		////*[@id="branding"]/a[1]/img
		WebElement title = driver.findElement(By.xpath("//*[@id=\"branding\"]/a[1]/img"));
		
		Actions action = new Actions(driver);
		action.contextClick(title).build().perform();
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
	}

}
