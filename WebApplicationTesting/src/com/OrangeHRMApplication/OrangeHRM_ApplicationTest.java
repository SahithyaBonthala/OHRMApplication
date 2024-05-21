package com.OrangeHRMApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class OrangeHRM_ApplicationTest extends BaseTest{
	
	XSSFSheet logInTestDataSheet;
	String expected_OrangeHRMApplicationLogInPageText;
	By orangeHRMApplicationLogInPageTextProperty;
	String actual_OrangeHRMApplicationLogInPageText;
	WebElement orangeHRMApplicationLogInPage;
	Row logInTestDataSheetRow;
	XSSFWorkbook workBook;
	Cell testRowOfCell;
	@Test(priority=1)
	public void logInPageTest() throws IOException
	{
		
		FileInputStream logInTestDataFile = new FileInputStream("./src/com/OrangeHRM_TestDataFile/OrangeHRM_AddEmployee.xlsx");
		workBook = new XSSFWorkbook(logInTestDataFile);
		logInTestDataSheet = workBook.getSheet("Sheet2");
		
		logInTestDataSheetRow=logInTestDataSheet.getRow(1);
		
		expected_OrangeHRMApplicationLogInPageText= logInTestDataSheetRow.getCell(0).getStringCellValue();
		System.out.println(" The Expected Text of the OrangeHRM Application LogIN Page is :- "+expected_OrangeHRMApplicationLogInPageText);

		orangeHRMApplicationLogInPageTextProperty=By.id("logInPanelHeading");
		orangeHRMApplicationLogInPage=driver.findElement(orangeHRMApplicationLogInPageTextProperty);

		actual_OrangeHRMApplicationLogInPageText=orangeHRMApplicationLogInPage.getText();
		System.out.println(" The Actual Text of the OrangeHRM Application LogIN Page is :- "+actual_OrangeHRMApplicationLogInPageText);
		testRowOfCell=logInTestDataSheetRow.createCell(1);
		testRowOfCell.setCellValue(actual_OrangeHRMApplicationLogInPageText);
		
		if(expected_OrangeHRMApplicationLogInPageText.equals(actual_OrangeHRMApplicationLogInPageText))
		{
		System.out.println(" Text Found - Successfully Navigated to OrangeHRM Application LogIn Page - PASS ");
		
		testRowOfCell=logInTestDataSheetRow.createCell(2);
		testRowOfCell.setCellValue(" Text Found - Successfully Navigated to OrangeHRM Application LogIn Page - PASS ");
		}
		else
		{
		System.out.println(" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
		
		testRowOfCell=logInTestDataSheetRow.createCell(2);
		testRowOfCell.setCellValue(" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
		}	
		
		String expected_OrangeHRMApplicationLogInPageTitle= logInTestDataSheetRow.getCell(3).getStringCellValue();
		System.out.println(" The Expected Title of the OrangeHRM Application LogIN Page is :- "+expected_OrangeHRMApplicationLogInPageTitle);

		String actual_OrangeHRMAplicationLogInPageTitle=driver.getTitle();
		System.out.println(" The actual title of the OrangeHRm Application LogIn Page is :- "+actual_OrangeHRMAplicationLogInPageTitle);
		testRowOfCell=logInTestDataSheetRow.createCell(4);
		testRowOfCell.setCellValue(actual_OrangeHRMAplicationLogInPageTitle);

		if(expected_OrangeHRMApplicationLogInPageTitle.equalsIgnoreCase(actual_OrangeHRMAplicationLogInPageTitle))
		{
			System.out.println(" Title Found - Successfully Navigated to OrangeHRM Application - PASS");
			testRowOfCell=logInTestDataSheetRow.createCell(5);
			testRowOfCell.setCellValue(" Title Found - Successfully Navigated to OrangeHRM Application - PASS");
		}
		else
		{
			System.out.println(" Title NOT Found - Failed to Navigated to the OrangeHRM Application - FAIL");
			testRowOfCell=logInTestDataSheetRow.createCell(5);
			testRowOfCell.setCellValue(" Title NOT Found - Failed to Navigated to the OrangeHRM Application - FAIL");
		}
		
		
	}
	
	@Test(priority=2)
	public void logInTest()
	{
		
		String userNameTestData= logInTestDataSheetRow.getCell(6).getStringCellValue();
		By userNameProperty=By.id("txtUsername");
		WebElement userName=driver.findElement(userNameProperty);
		userName.sendKeys(userNameTestData);
		
		String passwordTestData= logInTestDataSheetRow.getCell(7).getStringCellValue();
		By passwordProperty=By.id("txtPassword");
		WebElement password=driver.findElement(passwordProperty);
		password.sendKeys(passwordTestData);
		
		By buttonProperty=By.className("button");
		WebElement button=driver.findElement(buttonProperty);
		button.click();
	}
	
	@Test(priority=3)
	public void homePageTest()
	{
		
		String expected_OrangeHRMHomePageText= logInTestDataSheetRow.getCell(8).getStringCellValue();
		System.out.println(" The Expected Text of the OrangeHRM Application HomePage is : - " + expected_OrangeHRMHomePageText);
		
		By welComeAdminProperty=By.partialLinkText("Admin");
		WebElement welComeAdmin=driver.findElement(welComeAdminProperty);
		String actual_OrangeHRMApplicationHomePageText=welComeAdmin.getText();
		System.out.println(" The Actual Text of the OrangeHRM Application HomePage is :- "+actual_OrangeHRMApplicationHomePageText);
		testRowOfCell=logInTestDataSheetRow.createCell(9);
		testRowOfCell.setCellValue(actual_OrangeHRMApplicationHomePageText);
		
		if(actual_OrangeHRMApplicationHomePageText.contains(expected_OrangeHRMHomePageText))
		{
			System.out.println(" Text Found - Successfully Navigated to the OrangeHRM Home page - PASS ");
			testRowOfCell=logInTestDataSheetRow.createCell(10);
			testRowOfCell.setCellValue(" Text Found - Successfully Navigated to the OrangeHRM Home page - PASS ");			
		}
		else
		{
			System.out.println(" Text NOT Found - Failed to Navigate to the OrangeHRM Home page - FAIL ");
			testRowOfCell=logInTestDataSheetRow.createCell(10);
			testRowOfCell.setCellValue(" Text NOT Found - Failed to Navigate to the OrangeHRM Home page - FAIL ");		
		}

	}
	
	//@Test(enabled=false)
	@Test(priority=5)
	public void logOutTest() throws InterruptedException
	{
		
		 By welcomeProperty=By.id("welcome");
	     WebElement welcomeAdmin=driver.findElement(welcomeProperty);
	     welcomeAdmin.click();
	     
	     Thread.sleep(1000);
			    By logoutProperty=By.linkText("Logout");
	   		 WebElement logOut = driver.findElement(logoutProperty);     			
	   		logOut.click();
	}
	
	//@Test(enabled=false)
	@Test(priority=6)
	public void logInPageTestAfterLogOut() throws IOException
	{
		
		logInTestDataSheetRow=logInTestDataSheet.getRow(1); 
   		expected_OrangeHRMApplicationLogInPageText= logInTestDataSheetRow.getCell(29).getStringCellValue();
		System.out.println(" The Expected Text of the OrangeHRM Application LogIN Page is :- "+expected_OrangeHRMApplicationLogInPageText);

		orangeHRMApplicationLogInPageTextProperty=By.id("logInPanelHeading");
		orangeHRMApplicationLogInPage=driver.findElement(orangeHRMApplicationLogInPageTextProperty);

		actual_OrangeHRMApplicationLogInPageText=orangeHRMApplicationLogInPage.getText();
		System.out.println(" The Actual Text of the OrangeHRM Application LogIN Page is :- "+actual_OrangeHRMApplicationLogInPageText);
		testRowOfCell=logInTestDataSheetRow.createCell(30);
		testRowOfCell.setCellValue(actual_OrangeHRMApplicationLogInPageText);
		
		if(actual_OrangeHRMApplicationLogInPageText.equals(expected_OrangeHRMApplicationLogInPageText))
		{
		System.out.println(" Text Found - Successfully Navigated to OrangeHRM Application LogIn Page - PASS ");
		
		testRowOfCell=logInTestDataSheetRow.createCell(31);
		testRowOfCell.setCellValue(" Text Found - Successfully Navigated to OrangeHRM Application LogIn Page - PASS ");
		}
		else
		{
		System.out.println(" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
		
		testRowOfCell=logInTestDataSheetRow.createCell(31);
		testRowOfCell.setCellValue(" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
			
		}
		FileOutputStream testResultFile = new FileOutputStream("./src/com/OrangeHRMApplicationTestResultFiles/OrangeHRM_AddMultipleEmployeeResultFile.xlsx");
		workBook.write(testResultFile);

	}
	

}
