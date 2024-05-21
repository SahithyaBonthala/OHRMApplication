package com.DropDown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDown_GetOptionalValues {
	
	WebDriver driver;
	String applicationUrlAddress = "https://www.osmania.ac.in/";
	
	public void applicationLaunch()
	{
		
		System.setProperty("webdriver.chrome.driver", "./BrowserDriverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(applicationUrlAddress);
		
		driver.manage().window().maximize();
	}
	
	public void applicationClose()
	{
		driver.quit();
	}
	
	public void gettingOptionalValuesOfSelectLanguagesDropdown()
	{
		By selectLanguage_DropDownProperty=By.id("gtranslate_selector");
		WebElement selectLanguages= driver.findElement(selectLanguage_DropDownProperty);
		
		By dropDownProperty=By.tagName("option");
		List<WebElement>selectOptionalLanguages=selectLanguages.findElements(dropDownProperty);
		
		int selectOptionalLanguages_count=selectOptionalLanguages.size();
		System.out.println(" The number of languages in the Select Languages drop down is :- " + selectOptionalLanguages_count);
		
		for(int index=0;index<selectOptionalLanguages_count;index++)
		{
			String languageName=selectOptionalLanguages.get(index).getText();
			System.out.println(index + " " + languageName);
		}
		
	}
	
	
	public static void main(String[] args) {
		
		DropDown_GetOptionalValues osmaniaUniversity = new DropDown_GetOptionalValues();
		osmaniaUniversity.applicationLaunch();
		osmaniaUniversity.gettingOptionalValuesOfSelectLanguagesDropdown();
		osmaniaUniversity.applicationClose();
		
		
		
	}

}
