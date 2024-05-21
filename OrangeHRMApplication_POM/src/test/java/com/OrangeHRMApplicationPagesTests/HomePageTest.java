package com.OrangeHRMApplicationPagesTests;

import org.testng.annotations.Test;

import com.BaseTest.BaseTest;
import com.OrangeHRMApplicationPages.HomePage;

public class HomePageTest extends BaseTest {
	
	@Test(priority=1,description="  Validating OrangeHRM Application LogIN Page Text ")
	public void orangeHRMApplication_LogInPageTextTest() {
		HomePage logInText = new HomePage();
		logInText.orangeHRMApplicationLogInPage_LogInPannelTextValidation();
		
	}
	
	@Test(priority=3,description="  Validating OrangeHRM Application Home Page Text ")
	public void orangeHRMApplication_HomePageTextTest() {
		
		HomePage homePageTest = new HomePage();
		//homePageTest.orangeHRMApplicationLogInPage_logInValidation("Sahithya", "Sahithy@24");
		homePageTest.orangeHRMApplicationHomePageTextValidation();
	}
	
	@Test(priority=2,description="  Validating OrangeHRM Application LogIn Functionality ")
	public void orangeHRMApplication_LogInTestValidation() {
		
		HomePage LogInTest = new HomePage();
		LogInTest.orangeHRMApplicationLogInPage_logInValidation("Sahithya", "Sahithy@24");
	}

}
