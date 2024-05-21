package com.Assignment;

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
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM_Read_Write {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		 String urlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";
		 System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");
		 ChromeDriver chromeBrowser=new ChromeDriver();
		 
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
		 
			FileInputStream testDataFile = new FileInputStream("./src/com/OrangeHRM_TestDataFile/OHRM_LogInTestData.xlsx");
			
			XSSFWorkbook workBook = new XSSFWorkbook(testDataFile);
			
			XSSFSheet testDataSheet = workBook.getSheet("Sheet1");

			Row testDataSheetRow=testDataSheet.getRow(1);
			
			Cell testDataRowOfCell=testDataSheetRow.getCell(0);
			
			String expected_OrangeHRMApplicationLogInPageText=testDataRowOfCell.getStringCellValue();


		
			
		 //String expected_OrangeHRMApplicationLogInPageText="LOGIN Panel";
		 System.out.println(" The Expected Text of the OrangeHRM Application LogIN Page is :- "+expected_OrangeHRMApplicationLogInPageText);

		 By orangeHRMApplicationLogInPageTextProperty=By.id("logInPanelHeading");
		 WebElement orangeHRMApplicationLogInPage=chromeBrowser.findElement(orangeHRMApplicationLogInPageTextProperty);

		 String actual_OrangeHRMApplicationLogInPageText=orangeHRMApplicationLogInPage.getText();
		 System.out.println(" The Actual Text of the OrangeHRM Application LogIN Page is :- "+actual_OrangeHRMApplicationLogInPageText);

		 Cell newRowOfNewCell = testDataSheetRow.createCell(1);
	      newRowOfNewCell.setCellValue(actual_OrangeHRMApplicationLogInPageText);
	      
		 if(actual_OrangeHRMApplicationLogInPageText.equals(expected_OrangeHRMApplicationLogInPageText))
		 {
			 Cell rowOfCell = testDataSheetRow.createCell(2);
			 rowOfCell.setCellValue(" Text Found - Successfully Navigated to OrangeHRM Application LogIn Page - PASS ");
		 System.out.println(" Text Found - Successfully Navigated to OrangeHRM Application LogIn Page - PASS ");
		 }
		 else
		 {
		 System.out.println(" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
		 Cell rowOfCell = testDataSheetRow.createCell(2);
		 rowOfCell.setCellValue(" Text Found - Successfully Navigated to OrangeHRM Application LogIn Page - PASS ");
		 }

		 
		 testDataRowOfCell=testDataSheetRow.getCell(3);
		 String userNameTestData=testDataRowOfCell.getStringCellValue();
		// String userNameTestData="Sahithya";
		 By userNameProperty=By.id("txtUsername");
		 WebElement userName=chromeBrowser.findElement(userNameProperty);
		 userName.sendKeys(userNameTestData);
		 
		 testDataRowOfCell=testDataSheetRow.getCell(4);
			String passwordTestData=testDataRowOfCell.getStringCellValue(); 
		 
		// String passwordTestData="Sahithy@24";
		 By passwordProperty=By.name("txtPassword");
		 WebElement password=chromeBrowser.findElement(passwordProperty);
		 password.sendKeys(passwordTestData);
		 
		 //chromeBrowser.findElement(By.className("button")).click();
		 By buttonProperty=By.className("button");
		 WebElement button=chromeBrowser.findElement(buttonProperty);
		 button.click();
		 
		 By welComeAdminProperty=By.id("welcome");
	      
	      WebElement welComeAdmin=chromeBrowser.findElement(welComeAdminProperty);
	      
	      Cell welcomeRowOfCell=testDataSheetRow.getCell(5);
			
			String expected_OrangeHRMApplicationHomePageText=welcomeRowOfCell.getStringCellValue();


	      //String expected_OrangeHRMApplicationHomePageText="Welcome";
	      System.out.println(" The Expected Text of the OrangeHRM Application HomePage is :- "+expected_OrangeHRMApplicationHomePageText);

	      String actual_OrangeHRMApplicationHomePageText=welComeAdmin.getText();
	      System.out.println(" The Actual Text of the OrangeHRM Application HomePage is :- "+actual_OrangeHRMApplicationHomePageText);

	      Cell welcomeNewCell1 = testDataSheetRow.createCell(6);
	      welcomeNewCell1.setCellValue(actual_OrangeHRMApplicationHomePageText);
		
	      if(actual_OrangeHRMApplicationHomePageText.contains(expected_OrangeHRMApplicationHomePageText))
	      {
	    	  newRowOfNewCell = testDataSheetRow.createCell(7);
	    	  newRowOfNewCell.setCellValue(" Successfully Navigated to OrangeHRM Application HomePage - PASS  ");
	    	  System.out.println(" Successfully Navigated to OrangeHRM Application HomePage - PASS ");
	    	  
	      }
	      else
	      {
	    	  System.out.println(" Failed to Navigated to OrangeHRM Application HomePage - FAIL ");
	    	  newRowOfNewCell = testDataSheetRow.createCell(6);
	    	  newRowOfNewCell.setCellValue(" Failed to Navigated to OrangeHRM Application HomePage - FAIL ");
	      }
	      
	      By welcomeProperty=By.id("welcome");
	         WebElement welcomeAdmin=chromeBrowser.findElement(welcomeProperty);
	         welcomeAdmin.click();
	    
	      	Thread.sleep(1000);
	      		 
	      	// <a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>
	      		 
	      		 By logoutProperty=By.linkText("Logout");
	      		 WebElement innerElement1 = chromeBrowser.findElement(logoutProperty);     			
	      		 innerElement1.click();
	      		 
	      		testDataRowOfCell=testDataSheetRow.getCell(8);
				
				expected_OrangeHRMApplicationLogInPageText=testDataRowOfCell.getStringCellValue();

			 System.out.println(" The Expected Text of the OrangeHRM Application LogIN Page is :- "+expected_OrangeHRMApplicationLogInPageText);

			 orangeHRMApplicationLogInPageTextProperty=By.id("logInPanelHeading");
			 orangeHRMApplicationLogInPage=chromeBrowser.findElement(orangeHRMApplicationLogInPageTextProperty);

			 actual_OrangeHRMApplicationLogInPageText=orangeHRMApplicationLogInPage.getText();
			 System.out.println(" The Actual Text of the OrangeHRM Application LogIN Page is :- "+actual_OrangeHRMApplicationLogInPageText);

			 newRowOfNewCell = testDataSheetRow.createCell(9);
		      newRowOfNewCell.setCellValue(actual_OrangeHRMApplicationLogInPageText);
		      
			 if(actual_OrangeHRMApplicationLogInPageText.equals(expected_OrangeHRMApplicationLogInPageText))
			 {
				 Cell rowOfCell = testDataSheetRow.createCell(10);
				 rowOfCell.setCellValue(" Text Found - Successfully Navigated to OrangeHRM Application LogIn Page - PASS ");
			 System.out.println(" Text Found - Successfully Navigated to OrangeHRM Application LogIn Page - PASS ");
			 }
			 else
			 {
			 System.out.println(" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
			 Cell rowOfCell = testDataSheetRow.createCell(10);
			 rowOfCell.setCellValue(" Text Found - Successfully Navigated to OrangeHRM Application LogIn Page - PASS ");
			 }

	      		 
	      		 
	    	     
	      FileOutputStream testResultFile = new FileOutputStream("./src/com/OrangeHRMApplicationTestResultFiles/OrangeHrmLogIn_TestDataAssignment.xlsx");
		  workBook.write(testResultFile);
	      
		
	}

}
