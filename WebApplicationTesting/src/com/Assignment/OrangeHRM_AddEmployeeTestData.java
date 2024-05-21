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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OrangeHRM_AddEmployeeTestData {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		
		System.setProperty("webdriver.chrome.driver", "./BrowserDriverFiles/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get(applicationUrlAddress);
	
		FileInputStream logInTestDataFile = new FileInputStream("./src/com/OrangeHRM_TestDataFile/OrangeHRM_AddEmployee.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(logInTestDataFile);
		XSSFSheet logInTestDataSheet = workBook.getSheet("Sheet1");
		
		Row logInTestDataSheetRow=logInTestDataSheet.getRow(1);
		
		String expected_OrangeHRMApplicationLogInPageText= logInTestDataSheetRow.getCell(0).getStringCellValue();
		System.out.println(" The Expected Text of the OrangeHRM Application LogIN Page is :- "+expected_OrangeHRMApplicationLogInPageText);

		By orangeHRMApplicationLogInPageTextProperty=By.id("logInPanelHeading");
		WebElement orangeHRMApplicationLogInPage=driver.findElement(orangeHRMApplicationLogInPageTextProperty);

		String actual_OrangeHRMApplicationLogInPageText=orangeHRMApplicationLogInPage.getText();
		System.out.println(" The Actual Text of the OrangeHRM Application LogIN Page is :- "+actual_OrangeHRMApplicationLogInPageText);
		Cell testRowOfCell=logInTestDataSheetRow.createCell(1);
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

		By pimElementProperty=By.linkText("PIM");
		WebElement pimElementLink=driver.findElement(pimElementProperty);

		Actions mouseHoverOperation = new Actions(driver);
		mouseHoverOperation.moveToElement(pimElementLink).build().perform();
	    
		By addEmployeeElementProperty=By.linkText("Add Employee");
		WebElement addEmployeeElementLink=driver.findElement(addEmployeeElementProperty);
		addEmployeeElementLink.click();
		
		String expected_AddEmployeePageText= logInTestDataSheetRow.getCell(11).getStringCellValue();
		System.out.println(" The Expected Add Employee Page Text : - " + expected_AddEmployeePageText);
		
		//<label class="hasTopFieldHelp">Full Name</label>
		
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
		
		String expected_MiddleNameTestData= logInTestDataSheetRow.getCell(15).getStringCellValue();
		System.out.println(" Expected MiddleName : -" + expected_MiddleNameTestData);
		By middleNameProperty=By.id("middleName");
		WebElement middleName=driver.findElement(middleNameProperty);
		middleName.sendKeys(expected_MiddleNameTestData);
		
		String expected_LastNameTestData= logInTestDataSheetRow.getCell(16).getStringCellValue();
		System.out.println(" Expected LastName : -" + expected_LastNameTestData);
		By lastNameProperty=By.id("lastName");
		WebElement lastName=driver.findElement(lastNameProperty);
		lastName.sendKeys(expected_LastNameTestData);
		
	
		By employeeIdProperty=By.id("employeeId");
		WebElement employeeId=driver.findElement(employeeIdProperty);
		
		String expected_EmployeeId=employeeId.getAttribute("value");
		System.out.println("The expected EmployeeId : - " + expected_EmployeeId);
		Cell newRowOfNewCell = logInTestDataSheetRow.createCell(17);
		newRowOfNewCell.setCellValue(expected_EmployeeId);
		
		
		By saveButtonProperty=By.id("btnSave");
		WebElement saveButton=driver.findElement(saveButtonProperty);
		saveButton.click();
		
		String expected_PersonnelDetailsPageText= logInTestDataSheetRow.getCell(18).getStringCellValue();
		System.out.println(" The Expected Text of the Personnel Details Page is : - " + expected_PersonnelDetailsPageText);
		
		//<label for="Full_Name" class="hasTopFieldHelp">Full Name</label>
		
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
		
		
		 By welcomeProperty=By.id("welcome");
         WebElement welcomeAdmin=driver.findElement(welcomeProperty);
         welcomeAdmin.click();
         
         Thread.sleep(1000);
  		    By logoutProperty=By.linkText("Logout");
       		 WebElement innerElement1 = driver.findElement(logoutProperty);     			
       		 innerElement1.click();
       		 
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
    		FileOutputStream testResultFile = new FileOutputStream("./src/com/OrangeHRMApplicationTestResultFiles/OrangeHRM_AddEmployeeTestResultFile.xlsx");
    		workBook.write(testResultFile);
	 
		
		//driver.quit();

	}

}
