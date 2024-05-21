package com.WaitConcept;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Utility.Log;

public class LogInTest extends BaseTest{
	
	FileInputStream propertiesFile;
	Properties properties ;
	@Test(priority=1,description="Validating OrangeHRM Application LogIn Page")
	public void logInPageValidationTest() throws IOException {
		
		propertiesFile = new FileInputStream("./src/com/config/OrangeHRMApplication.properties");
		properties=new Properties();
		properties.load(propertiesFile);
		
		String expected_OrangeHRMApplicationLogInPageTitle="OrangeHRM";
		Log.info(" The Expected Title of the OrangeHRM Application page is : - " + expected_OrangeHRMApplicationLogInPageTitle);
		
		String actual_OrangeHRMApplicationLogInPageTitle=driver.getTitle();
		Log.info(" The Actual Title of the OrangeHRM Application page is : - " + actual_OrangeHRMApplicationLogInPageTitle);
		
		if(actual_OrangeHRMApplicationLogInPageTitle.equals(expected_OrangeHRMApplicationLogInPageTitle)) {
			
			Log.info(" Text Found - Successfully Navigated to the OrangeHRM Application WebPage - PASS ");
		}
		else {
			
			Log.info(" Text NOT Found - Failed to Navigate to the OrangeHRM Application WebPage - FAIL ");
			
		}
		
		String expected_OrangeHRMApplicationLogInPageText = "LOGIN Panel";
		Log.info(" The Expected Text of the OrangeHRM Appliation Login Page is : - " + expected_OrangeHRMApplicationLogInPageText);
		
		By LogInPageLogInPanelProperty=By.id(properties.getProperty("orangeHRMApplicationLogInPageTextProperty"));
		WebElement LogInPageLogInPanelText=driver.findElement(LogInPageLogInPanelProperty);
		String actual_OrangeHRMApplicationLogInPageText=LogInPageLogInPanelText.getText();
		
		if(actual_OrangeHRMApplicationLogInPageText.equals(expected_OrangeHRMApplicationLogInPageText)) {
			
			Log.info(" Text Found - Successfully Navigated to the OrangeHRM Application WebPage - PASS ");
		}
		else {
			 
			Log.info(" Text NOT Found - Failed to Navigate to the OrangeHRM Application WebPage - FAIL ");
		}
	}
	
	@Test(priority=2)
	public void logInTest() {
		
		By userNameProperty=By.id(properties.getProperty("orangeHRMLogInPageUserNameProperty"));
		WebElement userName=driver.findElement(userNameProperty);
		userName.sendKeys("Sahithya");
		
		By passwordProperty=By.name(properties.getProperty("orangeHRMLogInPagePasswordProperty"));
		WebElement password=driver.findElement(passwordProperty);
		password.sendKeys("Sahithy@24");
		
		By loginButtonProperty=By.className(properties.getProperty("orangeHRMLogInPageLogInButtonProperty"));
		WebElement loginButton=driver.findElement(loginButtonProperty);
		loginButton.click();
		
	}
	
	@Test(priority=3)
	public void homePageValidationTest() {
		
		String expected_OrangeHRMApplicationHomePageTest="Welcome";
		Log.info(" The Expected Text of the OrangeHRM Application Home Page is : - " + expected_OrangeHRMApplicationHomePageTest);
		
		By welComeAdminProperty=By.partialLinkText(properties.getProperty("orangeHRMHomePageWelComeAdminProperty"));
		WebElement welComeAdmin=driver.findElement(welComeAdminProperty);
		String actual_OrangeHRMApplicationHomePageTest=welComeAdmin.getText();
		
		if(actual_OrangeHRMApplicationHomePageTest.contains(expected_OrangeHRMApplicationHomePageTest)) {
			
			Log.info(" Text Found - Successfully Navigated to the OrangeHRM Application HomePage - PASS ");
		}
		else {
			
			Log.info(" Text NOT Found - Failed to Navigated to the OrangeHRM Application HomePage - FAIL ");
		}
	}
	
	@Test(priority=4)
	public void logOutTest() {
		
		By welComeAdminProperty=By.partialLinkText(properties.getProperty("orangeHRMHomePageWelComeAdminProperty"));
		WebElement welComeAdmin=driver.findElement(welComeAdminProperty);
		welComeAdmin.click();
		
		WebDriverWait logOutWebElementWait = new WebDriverWait(driver, 20);
		logOutWebElementWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
		
		By logOutProperty=By.linkText(properties.getProperty("orangeHRMHomePageLogOutProperty"));
		WebElement logOut=driver.findElement(logOutProperty);
		logOut.click();
	}

}
