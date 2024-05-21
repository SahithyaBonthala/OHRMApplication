package com.OrangeHRMApplicationPages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseTest.BaseTest;
import com.Utility.Log;



public class LogInPage  extends BaseTest{
	
	public LogInPage() {
		
		PageFactory.initElements(driver,this);
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
	
	@FindBy(xpath="/html/body/div[1]/div/div[2]/div/img")
	WebElement orangeHRMApplicationLogInPageLogo;
	/*
	public void orangeHRMApplicationLogInPageLogoValidation() {
		
		boolean flag=orangeHRMApplicationLogInPageLogo.isDisplayed();
		
		if(flag)
		{
			Log.info(" OrangeHRMApplication LogIn Page Logo Found - PASS ");
		}
		else
		{
			Log.info(" OrangeHRMApplication LogIn Page Logo NOT Found - FAIL ");
		}
	}
	*/
	
	public void orangeHRMApplicationLogInPageLogoValidation()
	{

	boolean flag=orangeHRMApplicationLogInPageLogo.isDisplayed();

	if(flag)
	{
	// System.out.println(" OrangeHRM Applicaiton LogIn page Logo found - PASS ");
	Log.info(" OrangeHRM Applicaiton LogIn page Logo found - PASS ");
	}
	else
	{
	Log.info(" OrangeHRM Applicaiton LogIn page Logo NOT found - FAIL ");
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
	
	

}
