package com.OHRM;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM_LogInTest {
	
	public static void main(String[] args) {
		
		/*
		
		String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";

		System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get(applicationUrlAddress);

		String expected_OrangeHRMAplicationLogInPageTitle="OrangeHRM";
		System.out.println(" The expected title of the OrangeHRm Application LogIn Page is :- "+expected_OrangeHRMAplicationLogInPageTitle);

		String actual_OrangeHRMAplicationLogInPageTitle=driver.getTitle();
		System.out.println(" The actual title of the OrangeHRm Application LogIn Page is :- "+actual_OrangeHRMAplicationLogInPageTitle);

		if(actual_OrangeHRMAplicationLogInPageTitle.equals(expected_OrangeHRMAplicationLogInPageTitle))
		{
		System.out.println("Successfully Navigated to OrangeHRM Application LogIn WebPage - PASS");
		}
		else
		{
		System.out.println("Failed to Navigate to OrangeHRM Application LogIn WebPage - FAIL");
		}
		
		driver.findElement(By.id("txtUsername")).sendKeys("Sahithya");
		
		driver.findElement(By.name("txtPassword")).sendKeys("Sahithy@24");
		
		driver.findElement(By.className("button")).click();
		
		*/
		
		 String urlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";
		
		 System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");
		 ChromeDriver chromeBrowser=new ChromeDriver();
		 
		// chromeBrowser.get("http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard");
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
		 
		 chromeBrowser.findElement(By.id("txtUsername")).sendKeys("Sahithya");		 
		 chromeBrowser.findElement(By.name("txtPassword")).sendKeys("Sahithy@24");		 
		chromeBrowser.findElement(By.className("button")).click();
		 /*
		 String passwordTestData="Q@Trainer7";
		 By passwordProperty=By.name("txtPassword");
		 WebElement password=driver.findElement(passwordProperty);
		 password.sendKeys(passwordTestData);
		 */
		 
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
		 
		 chromeBrowser.findElement(By.id("welcome")).click();
		 
		// WebElement panel=chromeBrowser.findElement(By.id("welcome-menu"));
		// By panelProperty=By.id("welcome-menu");
		 //WebElement panel=chromeBrowser.findElement(panelProperty);
		// panel.findElement(By.tagName("Logout")).click();
		 //By logoutProperty=By.linkText("Logout");
		/*
		By menuElement;
		Object wwelcome = menuElement.findElement(By.linkText("Logout")).click();
		 panel.click();
		 
		 */
		// <a href="#" data-dismiss="modal" id="aboutDisplayLink">About</a>
		 
		 WebElement containerElement = chromeBrowser.findElement(By.id("welcome-menu"));
		 
		 WebElement innerElement = containerElement.findElement(By.linkText("About"));
	
		 innerElement.click();
		 
		 
		 WebElement innerElement1 = containerElement.findElement(By.linkText("Logout"));
			
		 innerElement1.click();
		 
		 //<a href="/orangehrm-4.2.0.1/symfony/web/index.php/admin/changeUserPassword">Change Password</a>
		 
		 //chromeBrowser.findElement(By.linkText("Change Password")).click();
		 
		// <a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>
		 
		// panel.findElement(By.tagName("Logout")).click();
		 
		 
         chromeBrowser.findElement(By.id("txtUsername")).sendKeys("Sahithya");
		 
		 chromeBrowser.findElement(By.name("txtPassword")).sendKeys("Sahithy@24");
		 
		 chromeBrowser.findElement(By.className("button")).click();
		 
		 chromeBrowser.findElement(By.id("welcome")).click();
		 
         containerElement = chromeBrowser.findElement(By.id("welcome-menu"));
		 
		 innerElement = containerElement.findElement(By.linkText("About"));
	
		 innerElement.click();
		 WebElement innerElement2 = containerElement.findElement(By.linkText("Change Password"));
		 innerElement2.click();
		 
		 
		 
		 
		//chromeBrowser.quit();
		
		//driver.quit();
	}

}
