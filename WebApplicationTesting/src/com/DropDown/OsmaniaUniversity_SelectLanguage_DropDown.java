package com.DropDown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class OsmaniaUniversity_SelectLanguage_DropDown {
	
	public static void main(String[] args) {
			
			WebDriver driver ;
			String applicationUrlAddress = "https://www.osmania.ac.in/";
			System.setProperty("webdriver.chrome.driver", "./BrowserDriverFiles/chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.get(applicationUrlAddress);
			
			driver.manage().window().maximize();
			
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
			
			Select selectLanguage =new Select(driver.findElement(selectLanguage_DropDownProperty));
			selectLanguage.selectByVisibleText("Urdu");
			
		
	}

}
