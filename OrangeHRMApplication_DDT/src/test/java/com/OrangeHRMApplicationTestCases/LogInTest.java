package com.OrangeHRMApplicationTestCases;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.BaseTest.BaseTest;
import com.Utility.Log;



public class LogInTest extends BaseTest {
	
		XSSFSheet logInTestDataSheet;
		FileInputStream logInTestDataFile;
		FileInputStream propertiesFile;
		Properties properties;
		String expected_OrangeHRMApplicationLogInPageText;
		By orangeHRMApplicationLogInPageTextProperty;
		String actual_OrangeHRMApplicationLogInPageText;
		WebElement orangeHRMApplicationLogInPage;
		Row logInTestDataSheetRow;
		XSSFWorkbook workBook;
		Cell testRowOfCell;
		@Test(priority=1,description="Validating OrangeHRM Application LogIn WebPage")
		public void logInPageTest() throws IOException
		{
			
			logInTestDataFile = new FileInputStream("./src/main/java/com/OrangeHRMApplicationTestDataFiles/OrangeHRM_AddEmployee.xlsx");
			workBook = new XSSFWorkbook(logInTestDataFile);
			logInTestDataSheet = workBook.getSheet("Sheet2");
			
			propertiesFile = new FileInputStream("./src/main/java/com/Config/OrangeHRMApplication.properties");
			properties = new Properties();
			properties.load(propertiesFile);
			
			logInTestDataSheetRow=logInTestDataSheet.getRow(1);
			
			expected_OrangeHRMApplicationLogInPageText= logInTestDataSheetRow.getCell(0).getStringCellValue();
			Log.info(" The Expected Text of the OrangeHRM Application LogIN Page is :- "+expected_OrangeHRMApplicationLogInPageText);

			orangeHRMApplicationLogInPageTextProperty=By.id(properties.getProperty("orangeHRMApplicationLogInPageTextProperty"));
			orangeHRMApplicationLogInPage=driver.findElement(orangeHRMApplicationLogInPageTextProperty);

			actual_OrangeHRMApplicationLogInPageText=orangeHRMApplicationLogInPage.getText();
			Log.info(" The Actual Text of the OrangeHRM Application LogIN Page is :- "+actual_OrangeHRMApplicationLogInPageText);
			testRowOfCell=logInTestDataSheetRow.createCell(1);
			testRowOfCell.setCellValue(actual_OrangeHRMApplicationLogInPageText);
			
			if(expected_OrangeHRMApplicationLogInPageText.equals(actual_OrangeHRMApplicationLogInPageText))
			{
			Log.info(" Text Found - Successfully Navigated to OrangeHRM Application LogIn Page - PASS ");
			
			testRowOfCell=logInTestDataSheetRow.createCell(2);
			testRowOfCell.setCellValue(" Text Found - Successfully Navigated to OrangeHRM Application LogIn Page - PASS ");
			}
			else
			{
			Log.info(" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
			
			testRowOfCell=logInTestDataSheetRow.createCell(2);
			testRowOfCell.setCellValue(" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
			}	
			
			String expected_OrangeHRMApplicationLogInPageTitle= logInTestDataSheetRow.getCell(3).getStringCellValue();
			Log.info(" The Expected Title of the OrangeHRM Application LogIN Page is :- "+expected_OrangeHRMApplicationLogInPageTitle);

			String actual_OrangeHRMAplicationLogInPageTitle=driver.getTitle();
			Log.info(" The actual title of the OrangeHRm Application LogIn Page is :- "+actual_OrangeHRMAplicationLogInPageTitle);
			testRowOfCell=logInTestDataSheetRow.createCell(4);
			testRowOfCell.setCellValue(actual_OrangeHRMAplicationLogInPageTitle);

			if(expected_OrangeHRMApplicationLogInPageTitle.equalsIgnoreCase(actual_OrangeHRMAplicationLogInPageTitle))
			{
				Log.info(" Title Found - Successfully Navigated to OrangeHRM Application - PASS");
				testRowOfCell=logInTestDataSheetRow.createCell(5);
				testRowOfCell.setCellValue(" Title Found - Successfully Navigated to OrangeHRM Application - PASS");
			}
			else
			{
				Log.info(" Title NOT Found - Failed to Navigated to the OrangeHRM Application - FAIL");
				testRowOfCell=logInTestDataSheetRow.createCell(5);
				testRowOfCell.setCellValue(" Title NOT Found - Failed to Navigated to the OrangeHRM Application - FAIL");
			}
			
			
		}
		
		@Test(priority=2,description="Validating OrangeHRM Application LogIn Functionality")
		public void logInTest()
		{
			
			String userNameTestData= logInTestDataSheetRow.getCell(6).getStringCellValue();
			By userNameProperty=By.id(properties.getProperty("orangeHRMLogInPageUserNameProperty"));
			WebElement userName=driver.findElement(userNameProperty);
			userName.sendKeys(userNameTestData);
			
			String passwordTestData= logInTestDataSheetRow.getCell(7).getStringCellValue();
			By passwordProperty=By.id(properties.getProperty("orangeHRMLogInPagePasswordProperty"));
			WebElement password=driver.findElement(passwordProperty);
			password.sendKeys(passwordTestData);
			
			By buttonProperty=By.className(properties.getProperty("orangeHRMLogInPageLogInButtonProperty"));
			WebElement button=driver.findElement(buttonProperty);
			button.click();
		}
		
		@Test(priority=3,description="Validating OrangeHRM Application HomePage WebPage")
		public void homePageTest()
		{
			
			String expected_OrangeHRMHomePageText= logInTestDataSheetRow.getCell(8).getStringCellValue();
			Log.info(" The Expected Text of the OrangeHRM Application HomePage is : - " + expected_OrangeHRMHomePageText);
			
			By welComeAdminProperty=By.partialLinkText(properties.getProperty("orangeHRMHomePageWelComeAdminProperty"));
			WebElement welComeAdmin=driver.findElement(welComeAdminProperty);
			String actual_OrangeHRMApplicationHomePageText=welComeAdmin.getText();
			Log.info(" The Actual Text of the OrangeHRM Application HomePage is :- "+actual_OrangeHRMApplicationHomePageText);
			testRowOfCell=logInTestDataSheetRow.createCell(9);
			testRowOfCell.setCellValue(actual_OrangeHRMApplicationHomePageText);
			
			if(actual_OrangeHRMApplicationHomePageText.contains(expected_OrangeHRMHomePageText))
			{
				Log.info(" Text Found - Successfully Navigated to the OrangeHRM Home page - PASS ");
				testRowOfCell=logInTestDataSheetRow.createCell(10);
				testRowOfCell.setCellValue(" Text Found - Successfully Navigated to the OrangeHRM Home page - PASS ");			
			}
			else
			{
				Log.info(" Text NOT Found - Failed to Navigate to the OrangeHRM Home page - FAIL ");
				testRowOfCell=logInTestDataSheetRow.createCell(10);
				testRowOfCell.setCellValue(" Text NOT Found - Failed to Navigate to the OrangeHRM Home page - FAIL ");		
			}

		}

		@Test(priority=6,description="Validating OrangeHRM Application Logout Functionality")
		public void logOutTest() throws InterruptedException
		{
			
			By welComeAdminProperty=By.partialLinkText(properties.getProperty("orangeHRMHomePageWelComeAdminProperty"));
		     WebElement welcomeAdmin=driver.findElement(welComeAdminProperty);
		     welcomeAdmin.click();
		     
		     Thread.sleep(1000);
				    By logoutProperty=By.linkText(properties.getProperty("orangeHRMHomePageLogOutProperty"));
		   		 WebElement logOut = driver.findElement(logoutProperty);     			
		   		logOut.click();
		}
		
		@Test(priority=7,description="Validating OrangeHRM Application Login WebPage After LogOut")
		public void logInPageTestAfterLogOut() throws IOException
		{
			
			logInTestDataSheetRow=logInTestDataSheet.getRow(1); 
	   		expected_OrangeHRMApplicationLogInPageText= logInTestDataSheetRow.getCell(29).getStringCellValue();
			Log.info(" The Expected Text of the OrangeHRM Application LogIN Page is :- "+expected_OrangeHRMApplicationLogInPageText);

			orangeHRMApplicationLogInPageTextProperty=By.id(properties.getProperty("orangeHRMApplicationLogInPageTextProperty"));
			orangeHRMApplicationLogInPage=driver.findElement(orangeHRMApplicationLogInPageTextProperty);

			actual_OrangeHRMApplicationLogInPageText=orangeHRMApplicationLogInPage.getText();
			Log.info(" The Actual Text of the OrangeHRM Application LogIN Page is :- "+actual_OrangeHRMApplicationLogInPageText);
			testRowOfCell=logInTestDataSheetRow.createCell(30);
			testRowOfCell.setCellValue(actual_OrangeHRMApplicationLogInPageText);
			
			if(actual_OrangeHRMApplicationLogInPageText.equals(expected_OrangeHRMApplicationLogInPageText))
			{
			Log.info(" Text Found - Successfully Navigated to OrangeHRM Application LogIn Page - PASS ");
			
			testRowOfCell=logInTestDataSheetRow.createCell(31);
			testRowOfCell.setCellValue(" Text Found - Successfully Navigated to OrangeHRM Application LogIn Page - PASS ");
			}
			else
			{
			Log.info(" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
			
			testRowOfCell=logInTestDataSheetRow.createCell(31);
			testRowOfCell.setCellValue(" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
				
			}
			FileOutputStream testResultFile = new FileOutputStream("./src/main/java/com/OrangeHRMApplicationTestResultFiles/OrangeHRM_AddMultipleEmployeeResultFile.xlsx");
			workBook.write(testResultFile);

		}
		

	}



