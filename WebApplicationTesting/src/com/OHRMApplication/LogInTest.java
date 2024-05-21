package com.OHRMApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.OrangeHRMApplication.BaseTest;
import com.Utility.Log;

public class LogInTest extends BaseTest {
	
	@Test(priority=1)
	public void LogInPageTest()
	{
		
		String expected_ApplicationUrlAddress="orangehrm";
		 String actual_ApplicationUrlAddress=driver.getCurrentUrl();
		 
		 if(actual_ApplicationUrlAddress.contains(expected_ApplicationUrlAddress))
		 {
			 //System.out.println(" Successfully navigated to OrangeHRM login Page - URL found - Pass ");
			 Log.info(" Successfully navigated to OrangeHRM login Page - URL found - Pass ");
		 }
		 else
		 {
			// System.out.println(" Successfully navigated to OrangeHRM login Page - URL found - Fail "); 
			 Log.info(" Successfully navigated to OrangeHRM login Page - URL found - Fail ");
		 }
		 
		 String expected_OrangeHRmLoginPageTitle="OrangeHRM";
		 String actual_OrangeHRmLoginPageTitle=driver.getTitle();
		// System.out.println(" The Actual Title of the OrangeHRM Application login Page :- " + actual_OrangeHRmLoginPageTitle);
		 Log.info(" The Actual Title of the OrangeHRM Application login Page :- " + actual_OrangeHRmLoginPageTitle);
		 
		 if(expected_OrangeHRmLoginPageTitle.equals(actual_OrangeHRmLoginPageTitle))
		 {
			 
			 //System.out.println(" Successfully Navigated to OrangeHRM Application LogIn WebPage - PASS");
			 Log.info(" Successfully Navigated to OrangeHRM Application LogIn WebPage - PASS");
		 }
		 else
		 {
			// System.out.println(" Failed to Navigate to OrangeHRM Application LogIn WebPage - FAIL");
			 Log.info(" Failed to Navigate to OrangeHRM Application LogIn WebPage - FAIL");
		 }
		 
		 String expected_OrangeHRMApplicationLogInPageText="LOGIN Panel";
		 //System.out.println(" The Expected Text of the OrangeHRM Application LogIN Page is :- "+expected_OrangeHRMApplicationLogInPageText);
		 Log.info(" The Expected Text of the OrangeHRM Application LogIN Page is :- "+expected_OrangeHRMApplicationLogInPageText);

		 By orangeHRMApplicationLogInPageTextProperty=By.id("logInPanelHeading");
		 WebElement orangeHRMApplicationLogInPage=driver.findElement(orangeHRMApplicationLogInPageTextProperty);

		 String actual_OrangeHRMApplicationLogInPageText=orangeHRMApplicationLogInPage.getText();
		 //System.out.println(" The Actual Text of the OrangeHRM Application LogIN Page is :- "+actual_OrangeHRMApplicationLogInPageText);
		 Log.info(" The Actual Text of the OrangeHRM Application LogIN Page is :- "+actual_OrangeHRMApplicationLogInPageText);

		 if(actual_OrangeHRMApplicationLogInPageText.equals(expected_OrangeHRMApplicationLogInPageText))
		 {
		 //System.out.println(" Text Found - Successfully Navigated to OrangeHRM Application LogIn Page - PASS ");
			 Log.info(" Text Found - Successfully Navigated to OrangeHRM Application LogIn Page - PASS ");
		 }
		 else
		 {
		 // System.out.println(" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
		 Log.info(" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
		 }

	}
	FileInputStream propertiesFile;
	Properties properties;
	
	
	@Test(priority=2)
	public void logInTest() throws IOException
	{
		
		propertiesFile = new FileInputStream("./src/com/config/OrangeHRMApplication.properties");
		properties = new Properties();
		properties.load(propertiesFile);
		
		 String userNameTestData="Sahithya";
		 By userNameProperty=By.id(properties.getProperty("orangeHRMLogInPageUserNameProperty"));
		 WebElement userName=driver.findElement(userNameProperty);
		 userName.sendKeys(userNameTestData);
		 
		 String passwordTestData="Sahithy@24";
		 By passwordProperty=By.name(properties.getProperty("orangeHRMLogInPagePasswordProperty"));
		 WebElement password=driver.findElement(passwordProperty);
		 password.sendKeys(passwordTestData);

		 By buttonProperty=By.className(properties.getProperty("orangeHRMLogInPageLogInButtonProperty"));
		 WebElement button=driver.findElement(buttonProperty);
		 button.click();
	}
	
	@Test(priority=3)
	public void homePageTest() throws InterruptedException
	{
		
		 String expected_OrangeHRmHomePageTitle="OrangeHRM";
		 String actual_OrangeHRmHomePageTitle=driver.getTitle();
		// System.out.println(" The Actual Title of the OrangeHRM Application login Page :- " + actual_OrangeHRmHomePageTitle);
		 Log.info(" The Actual Title of the OrangeHRM Application login Page :- " + actual_OrangeHRmHomePageTitle);
		 
         if(expected_OrangeHRmHomePageTitle.equals(actual_OrangeHRmHomePageTitle)) {
			 
			// System.out.println(" Successfully Navigated to OrangeHRM Application Home WebPage - PASS");
        	 Log.info(" Successfully Navigated to OrangeHRM Application Home WebPage - PASS");
		 }
		 else {
			// System.out.println(" Failed to Navigate to OrangeHRM Application Home WebPage - FAIL");
			 Log.info(" Failed to Navigate to OrangeHRM Application Home WebPage - FAIL");
		 }
     
      By welComeAdminProperty=By.partialLinkText(properties.getProperty("orangeHRMHomePageWelComeAdminProperty"));
 
      WebElement welComeAdmin=driver.findElement(welComeAdminProperty);

      String expected_OrangeHRMApplicationHomePageText="Welcome";
      //System.out.println(" The Expected Text of the OrangeHRM Application HomePage is :- "+expected_OrangeHRMApplicationHomePageText);
      Log.info(" The Expected Text of the OrangeHRM Application HomePage is :- "+expected_OrangeHRMApplicationHomePageText);

      String actual_OrangeHRMApplicationHomePageText=welComeAdmin.getText();
      //System.out.println(" The Actual Text of the OrangeHRM Application HomePage is :- "+actual_OrangeHRMApplicationHomePageText);
      Log.info(" The Actual Text of the OrangeHRM Application HomePage is :- "+actual_OrangeHRMApplicationHomePageText);

      if(actual_OrangeHRMApplicationHomePageText.contains(expected_OrangeHRMApplicationHomePageText))
      {
      //System.out.println(" Successfully Navigated to OrangeHRM Application HomePage - PASS ");
      Log.info(" Successfully Navigated to OrangeHRM Application HomePage - PASS ");
      }
      else
      {
      //System.out.println("Failed to Navigate to OrangeHRM Application HomePage - FAIL ");
    	  Log.info("Failed to Navigate to OrangeHRM Application HomePage - FAIL ");
      }
       

	}
	@Test(priority=4)
	public void AddEmployeeTest()
	{
		By pimElementProperty=By.linkText("PIM");
		WebElement pimElementLink=driver.findElement(pimElementProperty);

		Actions mouseHoverOperation = new Actions(driver);
		mouseHoverOperation.moveToElement(pimElementLink).build().perform();
		
		By addEmployeeElementProperty=By.linkText("Add Employee");
		WebElement addEmployeeElementLink=driver.findElement(addEmployeeElementProperty);
		addEmployeeElementLink.click();
		///html/body/div[1]/div[3]/div/div[1]/h1
				By addEmployeeProperty=By.xpath("/html/body/div[1]/div[3]/div/div[1]/h1");
				WebElement addEmployee=driver.findElement(addEmployeeProperty);
				String actual_AddEmployeePageText = addEmployee.getText();
				System.out.println(" The Actual Text of the Add Employee Page : - " + actual_AddEmployeePageText);
	}
	
	@Test(priority=5)
	public void logOutTest() throws InterruptedException {
		
		 By welcomeProperty=By.partialLinkText(properties.getProperty("orangeHRMHomePageWelComeAdminProperty"));
         WebElement welcomeAdmin=driver.findElement(welcomeProperty);
         welcomeAdmin.click();
    
      	Thread.sleep(1000);
      
      		 By logoutProperty=By.linkText(properties.getProperty("orangeHRMHomePageLogOutProperty"));
      		 WebElement logOut = driver.findElement(logoutProperty);     			
      		logOut.click();
	}
	
	//@Test(priority=5)
	public void logInPageTestAfterLogOut()
	{
		
		String expected_OrangeHRMApplicationLogInPageText="LOGIN Panel";
   		System.out.println(" The Expected Text of the OrangeHRM Application LogIN Page is :- "+expected_OrangeHRMApplicationLogInPageText);

   		// id="logInPanelHeading"
   		By orangeHRMApplicationLogInPageTextProperty=By.id("logInPanelHeading");
   		WebElement orangeHRMApplicationLogInPage=driver.findElement(orangeHRMApplicationLogInPageTextProperty);

   		String actual_OrangeHRMApplicationLogInPageText=orangeHRMApplicationLogInPage.getText();
   		System.out.println(" The Actual Text of the OrangeHRM Application LogIN Page is :- "+actual_OrangeHRMApplicationLogInPageText);
   		
   		if(actual_OrangeHRMApplicationLogInPageText.equals(expected_OrangeHRMApplicationLogInPageText))
		 {
		 System.out.println(" Text Found - Successfully Navigated to OrangeHRM Application LogIn Page - PASS ");
		 }
		 else
		 {
		 System.out.println(" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
		 }
   		

	}

}
