package com.Assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM_LogInTest_Assignment1 {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		  
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

			FileInputStream logInTestDataFile = new FileInputStream("./src/com/OrangeHRM_TestDataFile/Multiple_TestData.xlsx");
			XSSFWorkbook workBook = new XSSFWorkbook(logInTestDataFile);
			XSSFSheet logInTestDataSheet = workBook.getSheet("Sheet1");
			
			int rowcount= logInTestDataSheet.getLastRowNum();		
			for(int rowIndex=0; rowIndex<=rowcount;rowIndex++)
			{
				Row logInTestDataSheetRow=logInTestDataSheet.getRow(rowIndex);
				
					 String testData= logInTestDataSheetRow.getCell(0).getStringCellValue();
					 String testData1= logInTestDataSheetRow.getCell(1).getStringCellValue();
					 
					 By userNamePoperty=By.id("txtUsername"); // Property of an element is identified and assigned to a variable
		
					 WebElement userName=driver.findElement(userNamePoperty); // finding a WebElement with the property in the current Webpage
						userName.sendKeys(testData);
						By passwordProperty=By.name("txtPassword");
						WebElement password=driver.findElement(passwordProperty);
						password.sendKeys(testData1);
					 

			// <input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
			By logInButtonProperty=By.className("button");
			WebElement logInButton=driver.findElement(logInButtonProperty);
			logInButton.click();
			
			try
			{

			By welComeAdminProperty=By.partialLinkText("Admin");

			WebElement welComeAdmin=driver.findElement(welComeAdminProperty);

			String expected_OrangeHRMApplicationHomePageText="Welcome";
			System.out.println(" The Expected Text of the OrangeHRM Application HomePage is :- "+expected_OrangeHRMApplicationHomePageText);

			String actual_OrangeHRMApplicationHomePageText=welComeAdmin.getText();
			System.out.println(" The Actual Text of the OrangeHRM Application HomePage is :- "+actual_OrangeHRMApplicationHomePageText);

			if(actual_OrangeHRMApplicationHomePageText.contains(expected_OrangeHRMApplicationHomePageText))
			{
			System.out.println(" Successfully Navigated to OrangeHRM Application HomePage - PASS ");

			//Row newRow=logInTestDataSheet.createRow(1);
			Cell testRowOfCell=logInTestDataSheetRow.createCell(2);
			testRowOfCell.setCellValue("Successfully Navigated to OrangeHRM Application HomePage - PASS");

			}
			else
			{
			System.out.println("Failed to Navigate to OrangeHRM Application HomePage - FAIL ");

			//Row newRow=logInTestDataSheet.createRow(1);
			Cell testRowOfCell=logInTestDataSheetRow.createCell(2);
			testRowOfCell.setCellValue("Failed to Navigate to OrangeHRM Application HomePage - FAIL ");
			}
			
			FileOutputStream testDataResultFile = new FileOutputStream("./src/com/OrangeHRM_TestDataFile/Multiple_TestDataAssignment.xlsx");
			workBook.write(testDataResultFile);
			
			welComeAdmin.click();

			Thread.sleep(1000); // wait for Java
			
			By logOutProperty=By.linkText("Logout");
			WebElement logOut=driver.findElement(logOutProperty);
			logOut.click();
			
			}
			catch(Exception e1)
			{
				
			}
			
			try
			{
			
			String expected_LogInPageText="Invalid credentials";
			//System.out.println(" The Expected Text of the OrangeHRM Application LogIN Page is :- "+expected_LogInPageText);

			By orangeHRMLogInPageTextProperty=By.id("spanMessage");
			WebElement orangeHRMLogInPage=driver.findElement(orangeHRMLogInPageTextProperty);

			String actual_OrangeHRMLogInPageText=orangeHRMLogInPage.getText();
			System.out.println(" The Actual Text of the OrangeHRM Application LogIN Page is :- "+actual_OrangeHRMLogInPageText);
			
			File logInPageScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(logInPageScreenShot, new File("./OrangeHRM_ScreenShots/" + actual_OrangeHRMLogInPageText+ rowIndex+ ".png"));
			
			if(expected_LogInPageText.equals(actual_OrangeHRMLogInPageText))
			{
				System.out.println(" Failed to navigate to the OrangeHRM Home Page ");
				
				Cell newRowOfNewCell = logInTestDataSheetRow.createCell(2);
				newRowOfNewCell.setCellValue(" Failed to navigate to the OrangeHRM Home Page ");
				
			}
			else
			{
				System.out.println(" Successfully navigated to the OrangeHRM Home Page ");
			}
			}
			catch(Exception e)
			{
				
			}
			FileOutputStream testDataResultFile = new FileOutputStream("./src/com/OrangeHRM_TestDataFile/Multiple_TestDataAssignment.xlsx");
			workBook.write(testDataResultFile);
					
			driver.navigate().refresh();
			
	       }

			driver.quit();
		
	}
	
	

}
