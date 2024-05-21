package com.Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class JQuery_GetText extends BaseTest {
	
	public void jQuery_getText_dragMeToMyTarget()
	{
		
		By jQueryFrameProperty = By.className("demo-frame");
		WebElement jQueryFrame = driver.findElement(jQueryFrameProperty);
		
		driver.switchTo().frame(jQueryFrame);
		
		
		By dragMeToMyTargetProperty = By.id("draggable");
		WebElement dragMeToMyTarget = driver.findElement(dragMeToMyTargetProperty);
		
		String dragMeToMyTargetText = dragMeToMyTarget.getText();
		
		System.out.println(" The Text of The WebElement is : - " + dragMeToMyTargetText);
	}
	
	public static void main(String[] args) {
		
		JQuery_GetText jQuery = new JQuery_GetText();
		jQuery.applicationLaunch();
		jQuery.jQuery_getText_dragMeToMyTarget();
		jQuery.applicationClose();
	}

}
