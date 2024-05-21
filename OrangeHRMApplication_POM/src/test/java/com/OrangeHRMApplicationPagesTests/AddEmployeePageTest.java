package com.OrangeHRMApplicationPagesTests;

import org.testng.annotations.Test;

import com.OrangeHRMApplicationPages.AddEmployeePage;
import com.OrangeHRMApplicationPages.LogInPage;

public class AddEmployeePageTest {
	
	@Test(priority=1,description="Validating OrangeHRM Application LogIN Page Text")
	public void orangeHRMApplicationLoginPageTextValidationTest() {
		
		AddEmployeePage addEmployee = new AddEmployeePage();
		addEmployee.orangeHRMApplicationLogInPage_LogInPannelTextValidation();
	}
	
	 @Test(priority=2,description=" Validating OrangeHRM Applicaiton LogIn Functionality ")
		public void orangeHRMApplicationLogInPage_LogInValidation() {
			
		 AddEmployeePage addEmployee = new AddEmployeePage();
		 addEmployee.orangeHRMApplicationLogInPage_logInValidation("Sahithya", "Sahithy@24");
		}
	
	@Test(priority=3,description="Validating OrangeHRM Application HomePage Text")
	public void orangeHRMApplicationHomePageTextValidationTest() {
		
		AddEmployeePage addEmployee = new AddEmployeePage();
		addEmployee.orangeHRMApplicationHomePageTextValidation();
	}
	
	@Test(priority=4,description="Validating OrangeHRM Application PIM Functionality")
	public void orangeHRMApplicationHomePagePIMTest() {
		
		AddEmployeePage addEmployee = new AddEmployeePage();
		addEmployee.orangeHRMApplicationHomePagePIMTest();
	}
	
	@Test(priority=5,description="Validating OrangeHRM Application Add Employee Page Text")
	public void orangeHRMApplicationAddEmployeePageValidationTest() {
		
		AddEmployeePage addEmployee = new AddEmployeePage();
		addEmployee.orangeHRMApplicationAddEmployeePageValidation();
	}
	
	@Test(priority=6,description="Validating OrangeHRM Application AddEmployee Functionality")
	public void orangeHRMApplicationAddEmployeeValidationTest() {
		
		AddEmployeePage addEmployee = new AddEmployeePage();
		addEmployee.OrangeHRMApplicationAddEmployeeValidation("Sahithya","Prabhakar","Bonthala");
	}

}
