package com.StepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Utility.Log;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class OrangeHRMApplicationUserDefinedMethods {
	
	WebDriver driver;
	
	String applicationUrlAddress = "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";
	
	public OrangeHRMApplicationUserDefinedMethods(Hooks hooks) {
		driver=Hooks.driver;
	}
	
	@Given("User should open Browser in the System")
	public void user_should_open_browser_in_the_system() {
		/*
		System.setProperty("webdriver.chrome.driver", "./ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		Log.info("**** Chrome Browser Launched Successfully *****");
	   */
	}

	@When("User enters OrangeHRM Application URL Address")
	public void user_enters_orange_hrm_application_url_address() {
		
        driver.get(applicationUrlAddress);
        
        Log.info(" Successfully Provided OrangeHRM Application Url address on the Browser ");
		
		driver.manage().window().maximize();
	   
	}

	@Then("User Should be Navigated to OrangeHRM Application LogIn WebPage")
	public void user_should_be_navigated_to_orange_hrm_application_log_in_web_page() {
		
		String expected_OrangeHRMApplicationLogInPageTitle="OrangeHRM";
		Log.info("The Expected title of the OrangeHRM Application LogIn Webpage is: - "+ expected_OrangeHRMApplicationLogInPageTitle);
		
		String actual_OrangeHRMApplicationLogInPageTitle=driver.getTitle();
		Log.info("The actual title of the OrangeHRM Application LogIn Webpage is: - "+ actual_OrangeHRMApplicationLogInPageTitle);
		
	    if(actual_OrangeHRMApplicationLogInPageTitle.equals(expected_OrangeHRMApplicationLogInPageTitle))
	    {
	    	Log.info(" Successfully navigated to OrangeHRM Application LogIn WebPage- PASS");
	    }
	    else {
	    	
	    	Log.info(" Failed to navigate to the OrangeHRM Application LogIn WebPage- FAIL");
	    }
	    
	    String expected_OrangeHRMApplicationLogInPageText="LOGIN Panel";
	    Log.info(" The expected Text of the OrangeHRM Application LogIn Webpage is : - " + expected_OrangeHRMApplicationLogInPageText);
	    
	    By orangeHRMApplicationLogInPageTextProperty=By.id("logInPanelHeading");
	    WebElement orangeHRMApplicationLogInPageText=driver.findElement(orangeHRMApplicationLogInPageTextProperty);
	    
	    String actual_OrangeHRMApplicationLogInPageText=orangeHRMApplicationLogInPageText.getText();
	    Log.info(" The actual Text of the OrangeHRM Application LogIn Webpage is : - " + actual_OrangeHRMApplicationLogInPageText);
	    if(actual_OrangeHRMApplicationLogInPageText.equals(expected_OrangeHRMApplicationLogInPageText))
	    {
	    	Log.info(" Text Found - Successfully navigated to OrangeHRM Application LogIn WebPage- PASS");
	    }
	    else {
	    	
	    	Log.info(" text Not Found - Failed to navigate to the OrangeHRM Application LogIn WebPage- FAIL");
	    }
	    
	}

	@Then("User Should Close the OrangeHRM Application along with the browser")
	public void user_should_close_the_orange_hrm_application_along_with_the_browser() {
		
		driver.quit();
		Log.info("***** OrangeHRM Application along with the Browser closed Succesfully *****");
	    
	}

	@Then("^User should enter Username and password and click on logIn button$")
	public void user_should_enter_Username_and_password_and_click_on_logIn_button() {
		
		String userNameTestData = "Sahithya";
		By userNameProperty=By.id("txtUsername");
		WebElement userName=driver.findElement(userNameProperty);
		userName.sendKeys(userNameTestData);
		
		String passwordTestData = "Sahithy@24";
		By passwordProperty=By.id("txtPassword");
		WebElement password=driver.findElement(passwordProperty);
		password.sendKeys(passwordTestData);
		
		By logInButtonproperty =  By.className("button");
		WebElement logInButton=driver.findElement(logInButtonproperty);
		logInButton.click();
	    
	}

	@Then("^User should be navigated to OrangeHRM Application Homepage$")
	public void user_should_be_navigated_to_OrangeHRM_Application_Homepage() {
		
		By welComeAdminProperty = By.partialLinkText("Admin");
		WebElement welComeAdmin=driver.findElement(welComeAdminProperty);
		String expected_OrangeHRMApplicationHomePageText = "Welcome";
		Log.info("The Expected Text of the OrangeHRM Application Homepage is : - "+expected_OrangeHRMApplicationHomePageText);
		
		String actual_OrangeHRMApplicationHomePageText = welComeAdmin.getText();
		Log.info("The Actual Text of the OrangeHRM Application Homepage is : - "+actual_OrangeHRMApplicationHomePageText);
		
		if(actual_OrangeHRMApplicationHomePageText.contains(expected_OrangeHRMApplicationHomePageText))
		{
			Log.info(" Successfully navigated to OrangeHRM Application HomePage - PASS");
		}
		else {
			Log.info(" Failed to navigate to OrangeHRM Application HomePage - FAIL");
			
		}
		
	}

	@Then("^User should click on Welcome Admin and click on logOut button$")
	public void user_should_click_on_Welcome_Admin_and_click_on_logOut_button() throws InterruptedException  {
		By welComeAdminProperty = By.partialLinkText("Admin");
		WebElement welComeAdmin=driver.findElement(welComeAdminProperty);
		welComeAdmin.click();
		
		Thread.sleep(1000);
		
		By logOutProperty = By.linkText("Logout");
		WebElement logOut=driver.findElement(logOutProperty);
		logOut.click();
	    
	}


	
	

}
