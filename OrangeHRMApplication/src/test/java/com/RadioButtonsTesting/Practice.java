package com.RadioButtonsTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.BaseTest.BaseTest;

public class Practice extends BaseTest {
	
	@Test
	public void main() throws InterruptedException {
		
		By buttonProperty = By.name("group1");
		List <WebElement> radioButtons = driver.findElements(buttonProperty);
		int buttonsCount = radioButtons.size();
		JavascriptExecutor js = (JavascriptExecutor)driver;		
		
		js.executeScript("window.scrollBy(0,1000)");
		
		for(int click=0; click<buttonsCount;click++) {
			
			String radioButtonsName = radioButtons.get(click).getAttribute("value");
			System.out.println(radioButtonsName);
			//Thread.sleep(5000);
			radioButtons.get(click).click();
			Thread.sleep(5000);
			for(int buttonStatus=0;buttonStatus<buttonsCount;buttonStatus++) {
				System.out.println(radioButtons.get(buttonStatus).getAttribute("value")+" - "+radioButtons.get(buttonStatus).getAttribute("checked"));
			}
			
		}
	}}