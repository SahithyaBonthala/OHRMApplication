package com.PracticeCucumber_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utility.Log;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserDefinedMethods {
	
	WebDriver driver;
	String applicationURLAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	
	public UserDefinedMethods(Hooks hooks)
	{
		driver = Hooks.driver;
	}
	@Given("^User Should Open Browser in the System$")
	public void user_Should_Open_Browser_in_the_System() {
	}

	@When("^User enters OrangeHRM Application URL Address$")
	public void user_enters_OrangeHRM_Application_URL_Address() {
		
		driver.get(applicationURLAddress);
	    Log.info(" Successfully provided OrangeHRM Application Url address on the Browser ");
	    
	    driver.manage().window().maximize();
	}

	@Then("^User should Be navigated to OrangeHRM Application LogIn WebPage$")
	public void user_should_Be_navigated_to_OrangeHRM_Application_LogIn_WebPage() {
	
		String expected_OrangeHRMApplicationLogInPageText="LOGIN Panel";
		Log.info(" The Expected Text of The OrangeHRM Application LogIn Page is : - "+ expected_OrangeHRMApplicationLogInPageText);
		
		//logInPanelHeading
		
		By logInPannelProperty=By.id("logInPanelHeading");
		WebElement logInPannel=driver.findElement(logInPannelProperty);
		String actual_OrangeHRMApplicationLogInPageText=logInPannel.getText();
		Log.info(" The Actual Text of The OrangeHRM Application LogIn Page is : - "+ actual_OrangeHRMApplicationLogInPageText);
		
		if(actual_OrangeHRMApplicationLogInPageText.equals(expected_OrangeHRMApplicationLogInPageText))
		{
			Log.info(" Text Found - Successfully navigated to the OrangeHRM Application - PASS ");
		}
		else {
			Log.info(" Text NOT Found - Failed to navigateto the OrangeHRM Application - FAIL");
		}
	}

	@Then("^User should close the orangeHRM Application along with the browser$")
	public void user_should_close_the_orangeHRM_Application_along_with_the_browser() {
	    
	}
	@Then("User Should enter userName and password and then click on login button")
	public void user_should_enter_user_name_and_password_and_then_click_on_login_button() {
		
		String userNameTestData="Sahithya";
		By userNameProperty=By.id("txtUsername");
		WebElement userName=driver.findElement(userNameProperty);
		userName.sendKeys(userNameTestData);
		
		String passwordTestData="Sahithy@24";
		By passwordProperty=By.id("txtPassword");
		WebElement password=driver.findElement(passwordProperty);
		password.sendKeys(passwordTestData);
		
		By buttonProperty=By.className("button");
		WebElement button=driver.findElement(buttonProperty);
		button.click();
	    
	}
	
	@Then("User should enter \\\"([^\\\"]*)\\\" and \\\"([^\\\"]*)\\\" and click on login button")
	public void user_should_enter_and_and_click_on_login_button(String userName, String password) {
	    
		//String userNameTestData="Sahithya";
		By userNameProperty=By.id("txtUsername");
		WebElement UserName=driver.findElement(userNameProperty);
		UserName.sendKeys(userName);
		
		//String passwordTestData="Sahithy@24";
		By passwordProperty=By.id("txtPassword");
		WebElement Password=driver.findElement(passwordProperty);
		Password.sendKeys(password);
		
		By buttonProperty=By.className("button");
		WebElement button=driver.findElement(buttonProperty);
		button.click();
	}

	@Then("User Should be navigated to OrangeHRM Application Home Page")
	public void user_should_be_navigated_to_orange_hrm_application_home_page() {
		try {
		String expected_OrangeHRMApplicationHomePageText = "Welcome";
		Log.info(" The Expected text of the orangeHRM Application HomePage is : - " + expected_OrangeHRMApplicationHomePageText);
		
		By welComeAdminProperty=By.linkText("Welcome Admin");
		WebElement welComeAdmin=driver.findElement(welComeAdminProperty);
		String actual_OrangeHRMApplicationHomePageText=welComeAdmin.getText();
		Log.info(" The Actual text of the orangeHRM Application HomePage is : - " + actual_OrangeHRMApplicationHomePageText);
		
		if(actual_OrangeHRMApplicationHomePageText.contains(expected_OrangeHRMApplicationHomePageText)) {
			
			Log.info(" Text Found - Successfully Navigated to the OrangeHRM Application Home Page - PASS ");
		}
		else {
			
			Log.info(" Text NOT Found - Failed to Navigate to the OrangeHRM Application Home Page - FAIL ");		
		}
		}catch(Exception e) {
			
		}
	   
	}

	@Then("User Should click on WelCome Admin and click on Logout")
	public void user_should_click_on_wel_come_admin_and_click_on_logout() {
		try {
		By welComeAdminProperty=By.linkText("Welcome Admin");
		WebElement welComeAdmin=driver.findElement(welComeAdminProperty);
		welComeAdmin.click();
		
		WebDriverWait logOutWebElementWait = new WebDriverWait(driver, 20);
		logOutWebElementWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
		
		By logOutProperty=By.linkText("Logout");
		WebElement logOut=driver.findElement(logOutProperty);
		logOut.click();
	}catch(Exception e) {
		
	}
	}


}
