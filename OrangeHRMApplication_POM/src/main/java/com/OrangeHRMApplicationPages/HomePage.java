package com.OrangeHRMApplicationPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseTest.BaseTest;
import com.Utility.Log;

public class HomePage extends BaseTest {
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="logInPanelHeading")
	WebElement logInPanelText;
	public void orangeHRMApplicationLogInPage_LogInPannelTextValidation() 
	{
		
		String expected_orangeHRMApplicationLogInPageLogInPannelText = "LOGIN Pannel";
		Log.info(" The Expected text of the WebElement LogIn Pannel is : - "+ expected_orangeHRMApplicationLogInPageLogInPannelText);
		
		String actual_orangeHRMApplicationLogInPageLogInPannelText = logInPanelText.getText();
		Log.info(" The Actual text of the WebElement LogIn Pannel is : - "+ actual_orangeHRMApplicationLogInPageLogInPannelText);
		
		if(actual_orangeHRMApplicationLogInPageLogInPannelText.equals(expected_orangeHRMApplicationLogInPageLogInPannelText)) {
			
			Log.info(" LogIn Pannel Text validation Successful - PASS ");
		}
		else {
			
			Log.info(" LogIn Pannel Text validation NOT Successful - FAIL ");
		}
	}
	
	@FindBy(id="txtUsername")
	WebElement userName;
	
	@FindBy(name="txtPassword")
	WebElement password;
	
	@FindBy(className="button")
	WebElement logInButton;
	
	public void orangeHRMApplicationLogInPage_logInValidation(String UserName,String Password) {
		userName.sendKeys(UserName);
		password.sendKeys(Password);
		logInButton.click();
	  
	}
	
	@FindBy(partialLinkText="Admin")
	WebElement welComeAdmin;
	public void orangeHRMApplicationHomePageTextValidation() {
		
		String expected_OrangeHRMHomePageText = "Welcome";		
		Log.info(" The Expected Text of the OrangeHRM Application HomePage is : - " + expected_OrangeHRMHomePageText);
		String actual_OrangeHRMApplicationHomePageText=welComeAdmin.getText();
		Log.info(" The Actual Text of the OrangeHRM Applicaton Home Page is : - " + actual_OrangeHRMApplicationHomePageText);
		if(actual_OrangeHRMApplicationHomePageText.contains(expected_OrangeHRMHomePageText)) {
			
			Log.info(" Text Found - Successfully Navigated to the OrangeHRM Home page - PASS ");
		}else {
			
			Log.info(" Text NOT Found - Failed to Navigate to the OrangeHRM Home page - FAIL ");
		}
	}
	

}
