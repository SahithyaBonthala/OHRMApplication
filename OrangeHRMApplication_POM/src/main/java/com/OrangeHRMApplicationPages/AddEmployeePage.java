package com.OrangeHRMApplicationPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseTest.BaseTest;
import com.Utility.Log;

public class AddEmployeePage extends BaseTest {
	
	public AddEmployeePage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="logInPanelHeading")
	WebElement logInPanelText;
	public void orangeHRMApplicationLogInPage_LogInPannelTextValidation() 
	{
		
		String expected_orangeHRMApplicationLogInPageLogInPannelText = "LOGIN Panel";
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
	
	@FindBy(linkText="PIM")
	WebElement pimElementLink;
    public void orangeHRMApplicationHomePagePIMTest() {
    	
    	Actions mouseHoverOperation = new Actions(driver);
		mouseHoverOperation.moveToElement(pimElementLink).build().perform();
    }
    @FindBy(linkText="Add Employee")
    WebElement addEmployeeElementLink;
    
    @FindBy(className="hasTopFieldHelp")
    WebElement fullName;
    public void orangeHRMApplicationAddEmployeePageValidation() {
    	
    	addEmployeeElementLink.click();
    	String expected_AddEmployeePageText="FullName";
    	Log.info(" The Expected Text of the Add Employee Page Text is : " + expected_AddEmployeePageText);
    	
    	String actual_AddEmployeePageText = fullName.getText();
    	Log.info(" The Actual Text of the Add Employee Page Text is : " + actual_AddEmployeePageText);
    	
    	if(actual_AddEmployeePageText.equals(expected_AddEmployeePageText)) {
    		
    		Log.info(" Text Found - Successfully Navigated to OrangeHRM Application Add Employee Page - PASS ");
    	}else {
    		
    		Log.info(" Text Not Found - Failed to Navigate to the OrangeHRM Application Add Employee Page - FAIL");
    	}
    	
    }
    
    @FindBy(id="firstName")
    WebElement firstname;
    
    @FindBy(id="btnSave")
    WebElement saveButton;
    
    public void OrangeHRMApplicationAddEmployeeValidation(String firstName,String middleName,String lastName) {
    	
    	firstname.sendKeys(firstName);
    	
    	Actions keyBoardActions = new Actions(driver);
    	keyBoardActions.sendKeys(Keys.TAB).build().perform();
    	keyBoardActions.sendKeys(middleName);
    	keyBoardActions.sendKeys(Keys.TAB).build().perform();
    	keyBoardActions.sendKeys(lastName);
    	
    	saveButton.click();
    }
    
    
}
