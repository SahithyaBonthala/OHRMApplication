package com.RadioButtonsTesting;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.BaseTest.BaseTest;

public class copy extends BaseTest{
	
	@Test
	public void radioButtonsTesting() throws InterruptedException {

		By grouplradiobuttonProperty = By.name("group1");

		List<WebElement> grouplradiobutton =driver.findElements (grouplradiobuttonProperty);

		By group2radiobuttonProperty= By.name("group2");

		List<WebElement> group2radiobutton= driver.findElements (group2radiobuttonProperty);

		int grouplradiobuttoncount= grouplradiobutton.size();

		int group2radiobuttoncount =group2radiobutton.size();

		System.out.println("The number of radio button Groupl are: "+ grouplradiobuttoncount+" | Group2 are:"+ group2radiobuttoncount);
		
		System.out.println();

		List<WebElement> allRadioButtons = new ArrayList<>();
		
		allRadioButtons.addAll (grouplradiobutton);

		allRadioButtons.addAll(group2radiobutton);

		for (WebElement radioButton: allRadioButtons)
		{
			
			
			

		String radioButtonName = radioButton.getAttribute("value");

		radioButton.click();

		Thread.sleep(2000);

		if (grouplradiobutton.contains(radioButton)) 
		{
			System.out.println("Group 1 Radio Button Status:"+radioButtonName);

			for (WebElement radioStatus: grouplradiobutton)
			{

			System.out.println(radioStatus.getAttribute("value") + " " + radioStatus.getAttribute("checked"));

			}
			
		}
			else if (group2radiobutton.contains(radioButton)) {

			System.out.println("Group 2 Radio Button Status: "+radioButtonName); 
			for (WebElement radioStatus: group2radiobutton) {

			System.out.println(radioStatus.getAttribute("value")+" " + radioStatus.getAttribute("checked"));

			System.out.println();

			}
		}
		}

	
		

}
}
