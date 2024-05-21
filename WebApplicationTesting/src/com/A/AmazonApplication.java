package com.A;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonApplication {
	
	WebDriver driver;
	String appliactionUrlAddress="https://www.amazon.in/";
	
	@BeforeMethod
	public void applicationLaunch() {
		
		System.setProperty("webdriver.chrome.driver", "./ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(appliactionUrlAddress);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	//@AfterMethod
	public void aplicationClose() {
		
		driver.quit();
	}
	
	@Test
	public void amazonTest() {
		//WebDriverWait wait= new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("field-keywords")));
		By searchProperty=By.name("field-keywords");
		WebElement search=driver.findElement(searchProperty);
		search.sendKeys("oneplus nord ce 3 lite 5g");
		
		Actions keyboardActions = new Actions(driver);
		keyboardActions.sendKeys(Keys.ENTER).build().perform();
		
		By mobileProperty= By.linkText("OnePlus Nord CE 3 Lite 5G (Chromatic Gray, 8GB RAM, 128GB Storage)");
		WebElement mobile=driver.findElement(mobileProperty);
		mobile.click();
		//*[@id="a-autoid-24"]/span/input
		By buttonProperty=By.className("a-button-text");
		WebElement button=driver.findElement(buttonProperty);
		System.out.println(button.getText());
		button.click();
		
		
		//html/body/div[2]/div/div[5]/div[13]/div/div/div/div/div/div/div[1]/div[1]/div[2]/div[2]/div[1]/a/div
		//html/body/div[2]/div/div[5]/div[13]/div/div/div/div/div/div/div[1]/div[1]/div[2]/div[2]/div[1]/a/div
		//html/body/div[2]/div/div[5]/div[13]/div/div/div/div/div/div/div[1]/div[1]/div[2]/div[2]/div[1]/a/div/span/text()
		/*
		By blockProperty=By.id("similarities_feature_div");
		WebElement block=driver.findElement(blockProperty);
		By suggestionProperty=By.xpath("//span[@class='a-size-base']");
		//By suggestionProperty=By.linkText("TheGiftKart Sleek Back Cover Case for OnePlus Nord CE 3 Lite 5G | Slim Fit Protective Design | Matte Finish | Camera Protection Bump | Soft Back Cover for OnePlus Nord CE 3 Lite (Silicone, Black)");
		WebElement suggestion=block.findElement(suggestionProperty);
		suggestion.click();
		*/
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div[5]/div[13]")));
		//html/body/div[2]/div/div[5]/div[13]
		//*[@id="similarities_feature_div"]
		//*[@id="ask-dp-search_feature_div"]
		By blockProperty=By.xpath("//*[@id=\"ask-dp-search_feature_div\"]");
		WebElement block=driver.findElement(blockProperty);
		/*
		By innerBlockProperty=By.cssSelector("a-cardui _p13n-desktop-sims-fbt_fbt-desktop_flex-fbt-container__3fI_9");
		WebElement innerBlock=block.findElement(innerBlockProperty);
		By suggestionProperty=By.cssSelector("a-size-base");
		//By suggestionProperty=By.linkText("TheGiftKart Sleek Back Cover Case for OnePlus Nord CE 3 Lite 5G | Slim Fit Protective Design | Matte Finish | Camera Protection Bump | Soft Back Cover for OnePlus Nord CE 3 Lite (Silicone, Black)");
		WebElement suggestion=innerBlock.findElement(suggestionProperty);
		suggestion.click();
		*/
		By suggestionProperty=By.tagName("a");
		List<WebElement> suggestion=block.findElements(suggestionProperty);
		System.out.println(suggestion.size());
		
		for(int i=0; i<suggestion.size();i++) {
			
			String linkName=suggestion.get(i).getText();
			System.out.println(linkName);
		}
	}

}
