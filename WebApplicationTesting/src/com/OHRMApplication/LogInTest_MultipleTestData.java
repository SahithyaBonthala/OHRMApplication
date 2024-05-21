package com.OHRMApplication;

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
import org.testng.annotations.Test;

import com.OrangeHRMApplication.BaseTest;


public class LogInTest_MultipleTestData extends BaseTest {
	
	XSSFSheet logInTestDataSheet ;
	XSSFWorkbook workBook ;
	FileInputStream logInTestDataFile;
	String expected_OrangeHRMApplicationLogInPageText;
	String actual_OrangeHRMApplicationLogInPageText;
	
	@Test(priority=1)
	public void LogInPageTest() throws IOException
	{
		
		logInTestDataFile = new FileInputStream("./src/com/OrangeHRM_TestDataFile/OHRM_MultipleLogInTestData.xlsx");
		workBook= new XSSFWorkbook(logInTestDataFile);
		logInTestDataSheet= workBook.getSheet("Sheet2");
		
		Row logInTestDataSheetRow=logInTestDataSheet.getRow(1);
		
		expected_OrangeHRMApplicationLogInPageText= logInTestDataSheetRow.getCell(0).getStringCellValue();
		System.out.println(" The Expected Text of the OrangeHRM Application LogIN Page is :- "+expected_OrangeHRMApplicationLogInPageText);

		By orangeHRMApplicationLogInPageTextProperty=By.id("logInPanelHeading");
		WebElement orangeHRMApplicationLogInPage=driver.findElement(orangeHRMApplicationLogInPageTextProperty);

		actual_OrangeHRMApplicationLogInPageText=orangeHRMApplicationLogInPage.getText();
		System.out.println(" The Actual Text of the OrangeHRM Application LogIN Page is :- "+actual_OrangeHRMApplicationLogInPageText);
		Cell testRowOfCell=logInTestDataSheetRow.createCell(2);
		testRowOfCell.setCellValue(actual_OrangeHRMApplicationLogInPageText);
		
		if(expected_OrangeHRMApplicationLogInPageText.equals(actual_OrangeHRMApplicationLogInPageText))
		{
		System.out.println(" Text Found - Successfully Navigated to OrangeHRM Application LogIn Page - PASS ");
		
		testRowOfCell=logInTestDataSheetRow.createCell(3);
		testRowOfCell.setCellValue(" Text Found - Successfully Navigated to OrangeHRM Application LogIn Page - PASS ");
		}
		else
		{
		System.out.println(" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
		
		testRowOfCell=logInTestDataSheetRow.createCell(3);
		testRowOfCell.setCellValue(" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
		}	
		
		
	}
	
	@Test(priority=2)
	public void LogInTest() throws InterruptedException
	{
		int rowcount= logInTestDataSheet.getLastRowNum();		
		for(int rowIndex=1; rowIndex<=rowcount;rowIndex++)
		{
			Row logInTestDataSheetRow=logInTestDataSheet.getRow(rowIndex);
			
				 String testData= logInTestDataSheetRow.getCell(4).getStringCellValue();
				 String testData1= logInTestDataSheetRow.getCell(5).getStringCellValue();
				 
				 By userNamePoperty=By.id("txtUsername"); 	
				 WebElement userName=driver.findElement(userNamePoperty);
					userName.sendKeys(testData);
					By passwordProperty=By.name("txtPassword");
					WebElement password=driver.findElement(passwordProperty);
					password.sendKeys(testData1);
	
		By logInButtonProperty=By.className("button");
		WebElement logInButton=driver.findElement(logInButtonProperty);
		logInButton.click();
		
		try
		{
		By welComeAdminProperty=By.partialLinkText("Admin");
		WebElement welComeAdmin=driver.findElement(welComeAdminProperty);

		String expected_OrangeHRMApplicationHomePageText=logInTestDataSheetRow.getCell(6).getStringCellValue();
		System.out.println(" The Expected Text of the OrangeHRM Application HomePage is :- "+expected_OrangeHRMApplicationHomePageText);

		String actual_OrangeHRMApplicationHomePageText=welComeAdmin.getText();
		System.out.println(" The Actual Text of the OrangeHRM Application HomePage is :- "+actual_OrangeHRMApplicationHomePageText);
		Cell testRowOfCell=logInTestDataSheetRow.createCell(7);
		testRowOfCell.setCellValue(actual_OrangeHRMApplicationHomePageText);

		if(actual_OrangeHRMApplicationHomePageText.contains(expected_OrangeHRMApplicationHomePageText))
		{
		System.out.println(" Successfully Navigated to OrangeHRM Application HomePage - PASS ");

		//Row newRow=logInTestDataSheet.createRow(1);
		testRowOfCell=logInTestDataSheetRow.createCell(8);
		testRowOfCell.setCellValue("Successfully Navigated to OrangeHRM Application HomePage - PASS");

		}
		else
		{
		System.out.println("Failed to Navigate to OrangeHRM Application HomePage - FAIL ");
		testRowOfCell=logInTestDataSheetRow.createCell(8);
		testRowOfCell.setCellValue("Failed to Navigate to OrangeHRM Application HomePage - FAIL ");
		}
		
		welComeAdmin.click();

		Thread.sleep(1000); 
		
		By logOutProperty=By.linkText("Logout");
		WebElement logOut=driver.findElement(logOutProperty);
		logOut.click();
		
		}
		catch(Exception e1)
		{
			
		}
		
		try
		{
		
		String expected_OrangeHRMApplicationLogInPageText=logInTestDataSheetRow.getCell(2).getStringCellValue();
		System.out.println(" The Expected Text of the OrangeHRM Application LogIN Page is :- "+expected_OrangeHRMApplicationLogInPageText);

		By orangeHRMLogInPageTextProperty=By.id("spanMessage");
		WebElement orangeHRMLogInPage=driver.findElement(orangeHRMLogInPageTextProperty);
	    String actual_OrangeHRMLogInPageText=orangeHRMLogInPage.getText();
		System.out.println(" The Actual Text of the OrangeHRM Application LogIN Page is :- "+actual_OrangeHRMLogInPageText);
		Cell newRowOfNewCell = logInTestDataSheetRow.createCell(2);
		newRowOfNewCell.setCellValue(actual_OrangeHRMLogInPageText);
		
		File logInPageScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(logInPageScreenShot, new File("./OrangeHRM_ScreenShots/" + actual_OrangeHRMLogInPageText+ rowIndex+ ".png"));
		
		if(expected_OrangeHRMApplicationLogInPageText.equals(actual_OrangeHRMLogInPageText))
		{
			System.out.println(" Failed to navigate to the OrangeHRM Home Page ");
			
			newRowOfNewCell = logInTestDataSheetRow.createCell(3);
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
		
		Thread.sleep(5000);
		try
		{
		
		String expected_OrangeHRMApplicationLogInPageText= logInTestDataSheetRow.getCell(0).getStringCellValue();
		System.out.println(" The Expected Text of the OrangeHRM Application LogIN Page is :- "+expected_OrangeHRMApplicationLogInPageText);

		By orangeHRMApplicationLogInPageTextProperty=By.id("logInPanelHeading");
		WebElement orangeHRMApplicationLogInPage=driver.findElement(orangeHRMApplicationLogInPageTextProperty);

		String actual_OrangeHRMApplicationLogInPageText=orangeHRMApplicationLogInPage.getText();
		System.out.println(" The Actual Text of the OrangeHRM Application LogIN Page is :- "+actual_OrangeHRMApplicationLogInPageText);
		Cell testRowOfCell=logInTestDataSheetRow.createCell(10);
		testRowOfCell.setCellValue(actual_OrangeHRMApplicationLogInPageText);
		
		if(expected_OrangeHRMApplicationLogInPageText.equals(actual_OrangeHRMApplicationLogInPageText))
		{
		System.out.println(" Text Found - Successfully Navigated to OrangeHRM Application LogIn Page - PASS ");
		
		testRowOfCell=logInTestDataSheetRow.createCell(11);
		testRowOfCell.setCellValue(" Text Found - Successfully Navigated to OrangeHRM Application LogIn Page - PASS ");
		}
		else
		{
		System.out.println(" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
		
		testRowOfCell=logInTestDataSheetRow.createCell(11);
		testRowOfCell.setCellValue(" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
		}	
		}
		catch(Exception e)
		{
			
		}
		
		}

		
	}
	

}
