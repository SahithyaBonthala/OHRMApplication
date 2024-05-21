package com.OHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM_ApplicationTest {
	public static void main(String[] args) throws InterruptedException {
		
		 String urlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";
		 System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");
		 ChromeDriver chromeBrowser=new ChromeDriver();
		 
         chromeBrowser.get(urlAddress);
		 
		 String expected_ApplicationUrlAddress="orangehrm";
		 String actual_ApplicationUrlAddress=chromeBrowser.getCurrentUrl();
		 
		 if(actual_ApplicationUrlAddress.contains(expected_ApplicationUrlAddress))
		 {
			 System.out.println(" Successfully navigated to OrangeHRM login Page - URL found - Pass ");
		 }
		 else
		 {
			 System.out.println(" Successfully navigated to OrangeHRM login Page - URL found - Fail "); 
		 }
		 
		 String expected_OrangeHRmLoginPageTitle="OrangeHRM";
		 String actual_OrangeHRmLoginPageTitle=chromeBrowser.getTitle();
		 System.out.println(" The Actual Title of the OrangeHRM Application login Page :- " + actual_OrangeHRmLoginPageTitle);
		 
		 if(expected_OrangeHRmLoginPageTitle.equals(actual_OrangeHRmLoginPageTitle)) {
			 
			 System.out.println(" Successfully Navigated to OrangeHRM Application LogIn WebPage - PASS");
		 }
		 else {
			 System.out.println(" Failed to Navigate to OrangeHRM Application LogIn WebPage - FAIL");
		 }
		 
		 String expected_OrangeHRMApplicationLogInPageText="LOGIN Panel";
		 System.out.println(" The Expected Text of the OrangeHRM Application LogIN Page is :- "+expected_OrangeHRMApplicationLogInPageText);

		 By orangeHRMApplicationLogInPageTextProperty=By.id("logInPanelHeading");
		 WebElement orangeHRMApplicationLogInPage=chromeBrowser.findElement(orangeHRMApplicationLogInPageTextProperty);

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

		 
		 //chromeBrowser.findElement(By.id("txtUsername")).sendKeys("Sahithya");
		 String userNameTestData="Sahithya";
		 By userNameProperty=By.id("txtUsername");
		 WebElement userName=chromeBrowser.findElement(userNameProperty);
		 userName.sendKeys(userNameTestData);
		 
		 //chromeBrowser.findElement(By.name("txtPassword")).sendKeys("Sahithy@24");
		 String passwordTestData="Sahithy@24";
		 By passwordProperty=By.name("txtPassword");
		 WebElement password=chromeBrowser.findElement(passwordProperty);
		 password.sendKeys(passwordTestData);
		 
		 //chromeBrowser.findElement(By.className("button")).click();
		 By buttonProperty=By.className("button");
		 WebElement button=chromeBrowser.findElement(buttonProperty);
		 button.click();
		 
		 String expected_OrangeHRmHomePageTitle="OrangeHRM";
		 String actual_OrangeHRmHomePageTitle=chromeBrowser.getTitle();
		 System.out.println(" The Actual Title of the OrangeHRM Application login Page :- " + actual_OrangeHRmHomePageTitle);
		 
         if(expected_OrangeHRmHomePageTitle.equals(actual_OrangeHRmHomePageTitle)) {
			 
			 System.out.println(" Successfully Navigated to OrangeHRM Application Home WebPage - PASS");
		 }
		 else {
			 System.out.println(" Failed to Navigate to OrangeHRM Application Home WebPage - FAIL");
		 }
         
      // <a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>
         

      By welComeAdminProperty=By.id("welcome");
      //By welComeAdminProperty=By.linkText("Welcome Admin");
     // By welComeAdminProperty=By.partialLinkText("Welcome");
     // By welComeAdminProperty=By.partialLinkText("Admin");

      WebElement welComeAdmin=chromeBrowser.findElement(welComeAdminProperty);

      String expected_OrangeHRMApplicationHomePageText="Welcome";
      System.out.println(" The Expected Text of the OrangeHRM Application HomePage is :- "+expected_OrangeHRMApplicationHomePageText);

      String actual_OrangeHRMApplicationHomePageText=welComeAdmin.getText();
      System.out.println(" The Actual Text of the OrangeHRM Application HomePage is :- "+actual_OrangeHRMApplicationHomePageText);

      if(actual_OrangeHRMApplicationHomePageText.contains(expected_OrangeHRMApplicationHomePageText))
      {
      System.out.println(" Successfully Navigated to OrangeHRM Application HomePage - PASS ");
      }
      else
      {
      System.out.println("Failed to Navigate to OrangeHRM Application HomePage - FAIL ");
      }

         
         //chromeBrowser.findElement(By.id("welcome")).click();
         By welcomeProperty=By.id("welcome");
         WebElement welcomeAdmin=chromeBrowser.findElement(welcomeProperty);
         welcomeAdmin.click();
         
      // <a href="#" data-dismiss="modal" id="aboutDisplayLink">About</a>
         /*
             welcomeProperty=By.id("welcome-menu");
      		 WebElement outerElement = chromeBrowser.findElement(welcomeProperty);
      		 
      		 By about=By.linkText("About");
      		 WebElement innerElement = outerElement.findElement(about);      	
      		 innerElement.click();
      		 */
      		 
      	Thread.sleep(5000);
      		 
      	// <a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>
      		 
      		 By logoutProperty=By.linkText("Logout");
      		 WebElement logOut = chromeBrowser.findElement(logoutProperty);     			
      		logOut.click();
      		 
      		expected_OrangeHRMApplicationLogInPageText="LOGIN Panel";
       		System.out.println(" The Expected Text of the OrangeHRM Application LogIN Page is :- "+expected_OrangeHRMApplicationLogInPageText);

       		// id="logInPanelHeading"
       		orangeHRMApplicationLogInPageTextProperty=By.id("logInPanelHeading");
       		orangeHRMApplicationLogInPage=chromeBrowser.findElement(orangeHRMApplicationLogInPageTextProperty);

       		actual_OrangeHRMApplicationLogInPageText=orangeHRMApplicationLogInPage.getText();
       		System.out.println(" The Actual Text of the OrangeHRM Application LogIN Page is :- "+actual_OrangeHRMApplicationLogInPageText);
       		 
      		 
         chromeBrowser.findElement(By.id("txtUsername")).sendKeys("Sahithya");
   		 
   		 chromeBrowser.findElement(By.name("txtPassword")).sendKeys("Sahithy@24");
   		 
   		 chromeBrowser.findElement(By.className("button")).click();
   		 
   		 
   		
   	     chromeBrowser.quit();
         
         
		
	}

}
