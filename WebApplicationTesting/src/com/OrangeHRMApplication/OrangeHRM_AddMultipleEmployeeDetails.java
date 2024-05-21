package com.OrangeHRMApplication;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class OrangeHRM_AddMultipleEmployeeDetails extends OrangeHRM_ApplicationTest {
	
	@Test(priority=4)
	public void excel_AddMultipleEmployee() throws InterruptedException, IOException
	{
		
		By pimElementProperty=By.linkText("PIM");
		WebElement pimElementLink=driver.findElement(pimElementProperty);

		Actions mouseHoverOperation = new Actions(driver);
		mouseHoverOperation.moveToElement(pimElementLink).build().perform();
		
		By addEmployeeElementProperty=By.linkText("Add Employee");
		WebElement addEmployeeElementLink=driver.findElement(addEmployeeElementProperty);
		addEmployeeElementLink.click();
		
		int rowcount= logInTestDataSheet.getLastRowNum();	
		System.out.println(rowcount);
		for(int rowIndex=1; rowIndex<=rowcount;rowIndex++)
			
		{
		logInTestDataSheetRow=logInTestDataSheet.getRow(rowIndex);
	   
		String expected_AddEmployeePageText= logInTestDataSheetRow.getCell(11).getStringCellValue();
		System.out.println(" The Expected Add Employee Page Text : - " + expected_AddEmployeePageText);
		
		///html/body/div[1]/div[3]/div/div[1]/h1
		By fullNameProperty=By.className("hasTopFieldHelp");
		WebElement fullname=driver.findElement(fullNameProperty);
		String actual_AddEmployeePageText = fullname.getText();
		System.out.println(" The Actual Text of the Add Employee Page : - " + actual_AddEmployeePageText);

		testRowOfCell=logInTestDataSheetRow.createCell(12);
		testRowOfCell.setCellValue(actual_AddEmployeePageText);
		
		if(expected_AddEmployeePageText.equals(actual_AddEmployeePageText))
		{
			System.out.println(" Text Found - Successfully navigated to Add Employee Page - PASS");
			Cell newRowOfNewCell = logInTestDataSheetRow.createCell(13);
			newRowOfNewCell.setCellValue(" Text Found - Successfully navigated to Add Employee Page - PASS");
			
		}
		else
		{
			System.out.println(" Text NOT Found - Failed to navigate to Add Employee Page - FAIL");
			Cell newRowOfNewCell = logInTestDataSheetRow.createCell(13);
			newRowOfNewCell.setCellValue(" Text NOT Found - Failed to navigate to Add Employee Page - FAIL");
		}
		
		String expected_FirstNameTestData= logInTestDataSheetRow.getCell(14).getStringCellValue();
		System.out.println(" Expected FirstName : -" + expected_FirstNameTestData);
		By firstNameProperty=By.id("firstName");
		WebElement firstName=driver.findElement(firstNameProperty);
		firstName.sendKeys(expected_FirstNameTestData);
		
		Actions keyboardActions = new Actions(driver);
		keyboardActions.sendKeys(Keys.TAB).build().perform();
		
		String expected_MiddleNameTestData= logInTestDataSheetRow.getCell(15).getStringCellValue();
		System.out.println(" Expected MiddleName : -" + expected_MiddleNameTestData);
		keyboardActions.sendKeys(expected_MiddleNameTestData).build().perform();
		/*
		By middleNameProperty=By.id("middleName");
		WebElement middleName=driver.findElement(middleNameProperty);
		middleName.sendKeys(expected_MiddleNameTestData);
		*/
		
		keyboardActions.sendKeys(Keys.TAB).build().perform();
		String expected_LastNameTestData= logInTestDataSheetRow.getCell(16).getStringCellValue();
		System.out.println(" Expected LastName : -" + expected_LastNameTestData);
		keyboardActions.sendKeys(expected_LastNameTestData).build().perform();
		/*
		By lastNameProperty=By.id("lastName");
		WebElement lastName=driver.findElement(lastNameProperty);
		lastName.sendKeys(expected_LastNameTestData);
		*/
		By employeeIdProperty=By.id("employeeId");
		WebElement employeeId=driver.findElement(employeeIdProperty);
		
		String expected_EmployeeId=employeeId.getAttribute("value");
		System.out.println("The expected EmployeeId : - " + expected_EmployeeId);
		Cell newRowOfNewCell = logInTestDataSheetRow.createCell(17);
		newRowOfNewCell.setCellValue(expected_EmployeeId);
		
		keyboardActions.sendKeys(Keys.TAB).build().perform();
		
		keyboardActions.sendKeys(Keys.TAB).build().perform();
		
		keyboardActions.sendKeys(Keys.ENTER).build().perform();
		
		Thread.sleep(10000);

		java.lang.Runtime.getRuntime().exec("./AutoItTestScripts/UploadEmployeePhoto.exe");

		Thread.sleep(5000);

		
		
		By saveButtonProperty=By.id("btnSave");
		WebElement saveButton=driver.findElement(saveButtonProperty);
		saveButton.click();
		
		String expected_PersonnelDetailsPageText= logInTestDataSheetRow.getCell(18).getStringCellValue();
		System.out.println(" The Expected Text of the Personnel Details Page is : - " + expected_PersonnelDetailsPageText);
		
		
		By personnelDetailsProperty = By.className("hasTopFieldHelp");
		WebElement personnelDetails=driver.findElement(personnelDetailsProperty);
		String actual_PersonnelDetailsPageText = personnelDetails.getText();
		System.out.println(" The Actual Text of the Personnel Details Page is : - " + actual_PersonnelDetailsPageText);
		newRowOfNewCell = logInTestDataSheetRow.createCell(19);
		newRowOfNewCell.setCellValue(actual_PersonnelDetailsPageText);
		
		if(expected_PersonnelDetailsPageText.equals(actual_PersonnelDetailsPageText))
		{
			System.out.println(" Text Found - Successfully Navigated to Personnel Details Page - PASS ");
			newRowOfNewCell = logInTestDataSheetRow.createCell(20);
			newRowOfNewCell.setCellValue(" Text Found - Successfully Navigated to Personnel Details Page - PASS ");
		}
		else
		{
			System.out.println(" Text NOT Found - Failed to Navigate to Personnel Details Page - FAIL ");
			newRowOfNewCell = logInTestDataSheetRow.createCell(20);
			newRowOfNewCell.setCellValue(" Text NOT Found - Failed to Navigate to Personnel Details Page - FAIL ");
		}
		By actual_FirstNameProperty=By.id("personal_txtEmpFirstName");
		WebElement firstNameElement=driver.findElement(actual_FirstNameProperty);
		
		String actual_FirstName=firstNameElement.getAttribute("value");
		System.out.println("Actual FirstName : - " + actual_FirstName);
		newRowOfNewCell = logInTestDataSheetRow.createCell(21);
		newRowOfNewCell.setCellValue(actual_FirstName);
		
		
		if(expected_FirstNameTestData.equals(actual_FirstName))
		{
			System.out.println(" Successfully Added Employee FirstName ");
			newRowOfNewCell = logInTestDataSheetRow.createCell(22);
			newRowOfNewCell.setCellValue(" Successfully Added Employee FirstName ");
		}
		else
		{
			System.out.println(" Failed to Add Employee FirstName ");
			newRowOfNewCell = logInTestDataSheetRow.createCell(22);
			newRowOfNewCell.setCellValue(" Failed to Add Employee FirstName ");
		}
		
		
		By actual_MiddleNameProperty=By.id("personal_txtEmpMiddleName");
		WebElement middleNameElement=driver.findElement(actual_MiddleNameProperty);
		
		String actual_MiddleName=middleNameElement.getAttribute("value");
		System.out.println("Actual MiddleName : - " + actual_MiddleName);
		newRowOfNewCell = logInTestDataSheetRow.createCell(23);
		newRowOfNewCell.setCellValue(actual_MiddleName);
		

		if(expected_MiddleNameTestData.equals(actual_MiddleName))
		{
			System.out.println(" Successfully Added Employee MiddleName ");
			newRowOfNewCell = logInTestDataSheetRow.createCell(24);
			newRowOfNewCell.setCellValue(" Successfully Added Employee MiddleName ");
		}
		else
		{
			System.out.println(" Failed to Add Employee MiddleName ");
			newRowOfNewCell = logInTestDataSheetRow.createCell(24);
			newRowOfNewCell.setCellValue(" Failed to Add Employee MiddleName ");
		}
		
		By actual_LastNameProperty=By.id("personal_txtEmpLastName");
		WebElement lastNameElement=driver.findElement(actual_LastNameProperty);
		
		String actual_LastName=lastNameElement.getAttribute("value");
		System.out.println("Actual LastName : - " + actual_LastName);
		newRowOfNewCell = logInTestDataSheetRow.createCell(25);
		newRowOfNewCell.setCellValue(actual_LastName);
		

		if(expected_LastNameTestData.equals(actual_LastName))
		{
			System.out.println(" Successfully Added Employee LastName ");
			newRowOfNewCell = logInTestDataSheetRow.createCell(26);
			newRowOfNewCell.setCellValue(" Successfully Added Employee LastName ");
		}
		else
		{
			System.out.println(" Failed to Add Employee LastName ");
			newRowOfNewCell = logInTestDataSheetRow.createCell(26);
			newRowOfNewCell.setCellValue(" Failed to Add Employee LastName ");
		}
		
				
		By employeeId_Property=By.id("personal_txtEmployeeId");
		WebElement empolyeeId=driver.findElement(employeeId_Property);
		
		String actual_EmployeeId=empolyeeId.getAttribute("value");
		System.out.println("Actual EmployeeId : - " + actual_EmployeeId);
	    newRowOfNewCell = logInTestDataSheetRow.createCell(27);
		newRowOfNewCell.setCellValue(actual_EmployeeId);


		if(expected_EmployeeId.equals(actual_EmployeeId))
		{
			System.out.println(" Employee Id Found ");
			newRowOfNewCell = logInTestDataSheetRow.createCell(28);
			newRowOfNewCell.setCellValue(" Employee Id Found ");
		}
		else
		{
			System.out.println(" Employee Id NOT Found ");
			newRowOfNewCell = logInTestDataSheetRow.createCell(28);
			newRowOfNewCell.setCellValue(" Employee Id NOT Found ");
			
		}
		
		driver.navigate().back();
		driver.navigate().refresh();
		}

	    }

  }

