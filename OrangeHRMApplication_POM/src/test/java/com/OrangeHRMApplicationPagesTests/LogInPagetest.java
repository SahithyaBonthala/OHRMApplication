package com.OrangeHRMApplicationPagesTests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.BaseTest.BaseTest;
import com.OrangeHRMApplicationPages.LogInPage;

public class LogInPagetest extends BaseTest {
	
	@Test(priority=1,description=" Validating OrangeHRM Application LogIN Page Text") 
	public void orangeHRMApplicationLogInPage_LogInPannelTextTest() throws IOException {
		
		LogInPage logInPage = new LogInPage();
	    logInPage.orangeHRMApplicationLogInPage_LogInPannelTextValidation();		
	}
	
	@Test(priority=2,description=" Validating OrangeHRM Applicaiton LogIn Page Logo ")
	public void orangeHRMApplicationLogInpage_LogoValidation() {
		
		LogInPage logInPage = new LogInPage();
		logInPage.orangeHRMApplicationLogInPageLogoValidation();
	}
	

    @Test(priority=3,description=" Validating OrangeHRM Applicaiton LogIn Functionality ")
	public void orangeHRMApplicationLogInPage_LogInValidation() {
		
		LogInPage logInPage = new LogInPage();
		logInPage.orangeHRMApplicationLogInPage_logInValidation("Sahithya", "Sahithy@24");
	}

}
