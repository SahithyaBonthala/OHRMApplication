package com.RadioButtonsTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.BaseTest.BaseTest;

public class EchoEchoApplication_RadioButtonsTesting extends BaseTest {
	
	@Test
	public void group1RadioButtonsTesting() throws InterruptedException
	{
		
		By group1RadioButtonsProperty=By.name("group1");
		List<WebElement>group1RadioButtons=driver.findElements(group1RadioButtonsProperty);

		int group1RadioButtonsCount=group1RadioButtons.size();
		System.out.println(" The number of Radio Buttons in Group1 are :- "+group1RadioButtonsCount);

		for(int radioButtonClick=0;radioButtonClick<group1RadioButtonsCount;radioButtonClick++)
		{
		String group1RadioButtonName=group1RadioButtons.get(radioButtonClick).getAttribute("value");
		System.out.println(group1RadioButtonName);

		group1RadioButtons.get(radioButtonClick).click();
		
		Thread.sleep(2000);
	    
		
		for(int radioButtonsStatus=0;radioButtonsStatus<group1RadioButtonsCount;radioButtonsStatus++ )
		{
		System.out.println(group1RadioButtons.get(radioButtonsStatus).getAttribute("value")+" - "+ group1RadioButtons.get(radioButtonsStatus).getAttribute("checked"));
		}
		}
}
}
