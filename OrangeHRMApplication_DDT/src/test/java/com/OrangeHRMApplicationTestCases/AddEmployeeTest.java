package com.OrangeHRMApplicationTestCases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.BaseTest.BaseTest;
import com.Utility.Log;
public class AddEmployeeTest extends BaseTest{

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
	@Test(priority=4,description="Validating OrangeHRM Application Home Page PIM Functionality ")
	public void pimPageTest() throws InterruptedException, IOException
	{
		
		By pimElementProperty=By.linkText(properties.getProperty("orangeHRMHomePagePIMProperty"));
		WebElement pimElementLink=driver.findElement(pimElementProperty);

		Actions mouseHoverOperation = new Actions(driver);
		mouseHoverOperation.moveToElement(pimElementLink).build().perform();
	}	
	
	@Test(priority=5,description="Validating OrangeHRM Application AddEmployee Functionality  Test ")
	public void addEmployeeTest() throws IOException, InterruptedException	{
		By addEmployeeElementProperty=By.linkText(properties.getProperty("orangeHRMHomePageAddEmployeeProperty"));
		WebElement addEmployeeElementLink=driver.findElement(addEmployeeElementProperty);
		addEmployeeElementLink.click();
		
		int rowcount= logInTestDataSheet.getLastRowNum();	
		Log.info(rowcount);
		for(int rowIndex=1; rowIndex<=rowcount;rowIndex++)
			
		{
		logInTestDataSheetRow=logInTestDataSheet.getRow(rowIndex);
	   
		String expected_AddEmployeePageText= logInTestDataSheetRow.getCell(11).getStringCellValue();
		Log.info(" The Expected Add Employee Page Text : - " + expected_AddEmployeePageText);
		
		///html/body/div[1]/div[3]/div/div[1]/h1
		By fullNameProperty=By.className("hasTopFieldHelp");
		WebElement fullname=driver.findElement(fullNameProperty);
		String actual_AddEmployeePageText = fullname.getText();
		Log.info(" The Actual Text of the Add Employee Page : - " + actual_AddEmployeePageText);

		testRowOfCell=logInTestDataSheetRow.createCell(12);
		testRowOfCell.setCellValue(actual_AddEmployeePageText);
		
		if(expected_AddEmployeePageText.equals(actual_AddEmployeePageText))
		{
			Log.info(" Text Found - Successfully navigated to Add Employee Page - PASS");
			Cell newRowOfNewCell = logInTestDataSheetRow.createCell(13);
			newRowOfNewCell.setCellValue(" Text Found - Successfully navigated to Add Employee Page - PASS");
			
		}
		else
		{
			Log.info(" Text NOT Found - Failed to navigate to Add Employee Page - FAIL");
			Cell newRowOfNewCell = logInTestDataSheetRow.createCell(13);
			newRowOfNewCell.setCellValue(" Text NOT Found - Failed to navigate to Add Employee Page - FAIL");
		}
		
		String expected_FirstNameTestData= logInTestDataSheetRow.getCell(14).getStringCellValue();
		Log.info(" Expected FirstName : -" + expected_FirstNameTestData);
		By firstNameProperty=By.id(properties.getProperty("orangeHRMAddEmployeePageFirstNameProperty"));
		WebElement firstName=driver.findElement(firstNameProperty);
		firstName.sendKeys(expected_FirstNameTestData);
		
		Actions keyboardActions = new Actions(driver);
		keyboardActions.sendKeys(Keys.TAB).build().perform();
		
		String expected_MiddleNameTestData= logInTestDataSheetRow.getCell(15).getStringCellValue();
		Log.info(" Expected MiddleName : -" + expected_MiddleNameTestData);
		keyboardActions.sendKeys(expected_MiddleNameTestData).build().perform();
		
		keyboardActions.sendKeys(Keys.TAB).build().perform();
		String expected_LastNameTestData= logInTestDataSheetRow.getCell(16).getStringCellValue();
		Log.info(" Expected LastName : -" + expected_LastNameTestData);
		keyboardActions.sendKeys(expected_LastNameTestData).build().perform();
		
		By employeeIdProperty=By.id(properties.getProperty("orangeHRMAddEmployeePageEmployeeIDProperty"));
		WebElement employeeId=driver.findElement(employeeIdProperty);
		
		String expected_EmployeeId=employeeId.getAttribute("value");
		Log.info("The expected EmployeeId : - " + expected_EmployeeId);
		Cell newRowOfNewCell = logInTestDataSheetRow.createCell(17);
		newRowOfNewCell.setCellValue(expected_EmployeeId);
		
		keyboardActions.sendKeys(Keys.TAB).build().perform();
		
		keyboardActions.sendKeys(Keys.TAB).build().perform();
		
		keyboardActions.sendKeys(Keys.ENTER).build().perform();
		
		//Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		java.lang.Runtime.getRuntime().exec("./OrangeHRMApplicationAutoITTestScripts/UploadEmployeePhotographDesktop.exe");

		//Thread.sleep(5000);

		
		
		By saveButtonProperty=By.id(properties.getProperty("orangeHRMAddEmployeePageSaveButtonProperty"));
		WebElement saveButton=driver.findElement(saveButtonProperty);
		saveButton.click();
		
		String expected_PersonnelDetailsPageText= logInTestDataSheetRow.getCell(18).getStringCellValue();
		Log.info(" The Expected Text of the Personnel Details Page is : - " + expected_PersonnelDetailsPageText);
		
		
		By personnelDetailsProperty = By.className(properties.getProperty("orangeHRMPersonalDetailsPageTextProperty"));
		WebElement personnelDetails=driver.findElement(personnelDetailsProperty);
		String actual_PersonnelDetailsPageText = personnelDetails.getText();
		Log.info(" The Actual Text of the Personnel Details Page is : - " + actual_PersonnelDetailsPageText);
		newRowOfNewCell = logInTestDataSheetRow.createCell(19);
		newRowOfNewCell.setCellValue(actual_PersonnelDetailsPageText);
		
		if(expected_PersonnelDetailsPageText.equals(actual_PersonnelDetailsPageText))
		{
			Log.info(" Text Found - Successfully Navigated to Personnel Details Page - PASS ");
			newRowOfNewCell = logInTestDataSheetRow.createCell(20);
			newRowOfNewCell.setCellValue(" Text Found - Successfully Navigated to Personnel Details Page - PASS ");
		}
		else
		{
			Log.info(" Text NOT Found - Failed to Navigate to Personnel Details Page - FAIL ");
			newRowOfNewCell = logInTestDataSheetRow.createCell(20);
			newRowOfNewCell.setCellValue(" Text NOT Found - Failed to Navigate to Personnel Details Page - FAIL ");
		}
		By actual_FirstNameProperty=By.id(properties.getProperty("orangeHRMPersonalDetailsPageFirstNameTextProperty"));
		WebElement firstNameElement=driver.findElement(actual_FirstNameProperty);
		
		String actual_FirstName=firstNameElement.getAttribute("value");
		Log.info("Actual FirstName : - " + actual_FirstName);
		newRowOfNewCell = logInTestDataSheetRow.createCell(21);
		newRowOfNewCell.setCellValue(actual_FirstName);
		
		
		if(expected_FirstNameTestData.equals(actual_FirstName))
		{
			Log.info(" Successfully Added Employee FirstName ");
			newRowOfNewCell = logInTestDataSheetRow.createCell(22);
			newRowOfNewCell.setCellValue(" Successfully Added Employee FirstName ");
		}
		else
		{
			Log.info(" Failed to Add Employee FirstName ");
			newRowOfNewCell = logInTestDataSheetRow.createCell(22);
			newRowOfNewCell.setCellValue(" Failed to Add Employee FirstName ");
		}
		
		
		By actual_MiddleNameProperty=By.id(properties.getProperty("orangeHRMPersonalDetailsPageMiddleNameTextProperty"));
		WebElement middleNameElement=driver.findElement(actual_MiddleNameProperty);
		
		String actual_MiddleName=middleNameElement.getAttribute("value");
		Log.info("Actual MiddleName : - " + actual_MiddleName);
		newRowOfNewCell = logInTestDataSheetRow.createCell(23);
		newRowOfNewCell.setCellValue(actual_MiddleName);
		

		if(expected_MiddleNameTestData.equals(actual_MiddleName))
		{
			Log.info(" Successfully Added Employee MiddleName ");
			newRowOfNewCell = logInTestDataSheetRow.createCell(24);
			newRowOfNewCell.setCellValue(" Successfully Added Employee MiddleName ");
		}
		else
		{
			Log.info(" Failed to Add Employee MiddleName ");
			newRowOfNewCell = logInTestDataSheetRow.createCell(24);
			newRowOfNewCell.setCellValue(" Failed to Add Employee MiddleName ");
		}
		
		By actual_LastNameProperty=By.id(properties.getProperty("orangeHRMPersonalDetailsPageLastNameTextProperty"));
		WebElement lastNameElement=driver.findElement(actual_LastNameProperty);
		
		String actual_LastName=lastNameElement.getAttribute("value");
		Log.info("Actual LastName : - " + actual_LastName);
		newRowOfNewCell = logInTestDataSheetRow.createCell(25);
		newRowOfNewCell.setCellValue(actual_LastName);
		

		if(expected_LastNameTestData.equals(actual_LastName))
		{
			Log.info(" Successfully Added Employee LastName ");
			newRowOfNewCell = logInTestDataSheetRow.createCell(26);
			newRowOfNewCell.setCellValue(" Successfully Added Employee LastName ");
		}
		else
		{
			Log.info(" Failed to Add Employee LastName ");
			newRowOfNewCell = logInTestDataSheetRow.createCell(26);
			newRowOfNewCell.setCellValue(" Failed to Add Employee LastName ");
		}
		
				
		By employeeId_Property=By.id(properties.getProperty("orangeHRMPersonalDetailsPageEmployeeIDTextProperty"));
		WebElement empolyeeId=driver.findElement(employeeId_Property);
		
		String actual_EmployeeId=empolyeeId.getAttribute("value");
		Log.info("Actual EmployeeId : - " + actual_EmployeeId);
	    newRowOfNewCell = logInTestDataSheetRow.createCell(27);
		newRowOfNewCell.setCellValue(actual_EmployeeId);


		if(expected_EmployeeId.equals(actual_EmployeeId))
		{
			Log.info(" Employee Id Found ");
			newRowOfNewCell = logInTestDataSheetRow.createCell(28);
			newRowOfNewCell.setCellValue(" Employee Id Found ");
		}
		else
		{
			Log.info(" Employee Id NOT Found ");
			newRowOfNewCell = logInTestDataSheetRow.createCell(28);
			newRowOfNewCell.setCellValue(" Employee Id NOT Found ");
			
		}
		
		By empImageProperty=By.id("empPic");
		WebElement empImage=driver.findElement(empImageProperty);
		
		boolean flag = empImage.isDisplayed();
		
		if(flag) {
			
			Log.info(" Employee Photograph existing - PASS ");
		}
		else {
			
			Log.info(" Employee Photograph NOT existing - FAIL ");
		}
		
		driver.navigate().back();
		driver.navigate().refresh();
		}

	    }
	@Test(priority=6)
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
	
	FileOutputStream testResultFile;
	@Test(priority=7)
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
		testResultFile = new FileOutputStream("./src/main/java/com/OrangeHRMApplicationTestResultFiles/OrangeHRM_AddMultipleEmployeeResultFile.xlsx");
		workBook.write(testResultFile);

	}

  }


