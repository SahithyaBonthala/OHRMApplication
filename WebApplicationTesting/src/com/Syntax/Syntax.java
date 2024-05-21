package com.Syntax;


import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utility.Log;

public class Syntax {
	public static void main(String[] args) {
		
	

	//Automating  Browser
	WebDriver driver;
	System.setProperty("webdriver.chrome.driver", "./ChromeDriver.chromedriver.exe");
	//driver-Object (Always points to current browser)
	driver = new ChromeDriver();
	//Navigating to the Application HomePage
	driver.get(null);

	driver.navigate().to("URL");//will open the same browser of the same tab
	driver.close();//close method will close the browser when it is opened with single tab
	driver.quit();//quit method will close the browser when it is opened with single tab and also closes the browser with multiple tab's
	
	//Identifying the title of the current page
	String variableName=driver.getTitle();
	
	//validating title of the webpage
	if(variableName.equals(variableName1))
	{
		Log.info(" Text Found ");
	}else
	{
		Log.info(" Text NOT Found ");
	}
	
	//getting the Url of the current WebPage
	driver.getCurrentUrl();
	
	//Validating Url Address
	if(variableName.contains(variableName1))
	{
		Log.info(" Text Found ");
	}else
	{
		Log.info(" Text NOT Found ");
	}
	
	//Identifying the element of the webpage -using properties 
	
	driver.findElement(By.id("selector")).sendKeys(args);
	//id -  any locator
	WebElement variable = driver.findElement(By.id("Selector"));
	variable.sendKeys(args);
	
	By property = By.id("Selector");
	WebElement variablename = driver.findElement(property);
	variablename.sendKeys(" ");
	
	String testData = " TestData";
	By property1 = By.id("Selector");
	WebElement variablename1 = driver.findElement(property);
	variablename.sendKeys(testData);
	variablename.click();//click operation
	
	//getting the text of WebElement
	By property2 = By.id("Selector");
	WebElement variablename2 = driver.findElement(property);
	String text=variablename2.getText();
	
	//getting the attribute value
	String attributeValue=variablename2.getAttribute("AttributeName");
	
	//Whenever we work on a group of similar type of elements we look for a common property existing among them 
	List<WebElement> var = driver.findElements(By.id(" "));
	var.size();//to get the count of the elements
	
	//coming back to previous page
	driver.navigate().refresh();
	driver.navigate().back();
	
	//Excel operations
	//Read
	//Identifying the file in the system
	FileInputStream file = new FileInputStream(" path of the Excel file ");
	//Identifying workBook in the file
	XSSFWorkbook book = new XSSFWorkbook(file);
	//identifying the sheet in the Workbook
	XSSFSheet sheet = book.getSheet("SheetName");
	//identifying the row in the sheet
	Row row =sheet.getRow(0);
	//identifying rowofCell in the row
	Cell cell=row.getCell(0);
	//Get TestData from the rowOfCell 
	String TestData=cell.getStringCellValue();
	System.out.println(TestData);//prints the value from the Cell 
	
	//Read Multiple TestData
	//Identifying the file in the system
		FileInputStream file = new FileInputStream(" path of the Excel file ");
		//Identifying workBook in the file
		XSSFWorkbook book = new XSSFWorkbook(file);
		//identifying the sheet in the Workbook
		XSSFSheet sheet = book.getSheet("SheetName");
		//identifying no of active rows in the sheet
		int count=sheet.getLastRowNum();
		for(int i=0; i<count; i++) {
			Row newrow =sheet.getRow( i);
			int cellCount=newrow.getLastCellNum();
			for(int j=0; j<cellCount;j++) {
				Cell newcell=row.getCell(j);
				String value=newcell.getStringCellValue();
			}
		}
	
		//Write operations
		//Identifying the file in the system
				FileInputStream file = new FileInputStream(" path of the Excel file ");
				//Identifying workBook in the file
				XSSFWorkbook book = new XSSFWorkbook(file);
				//identifying the sheet in the Workbook
				XSSFSheet sheet = book.getSheet("SheetName");
				//Creating new row in the Sheet
				Row NewRow = sheet.createRow(0);
				//creating Newcell in the newRow
				Cell NewCell = NewRow.createCell(count);
				NewCell.setCellValue("");
		
		//Multiple
				//Identifying the file in the system
				FileInputStream file = new FileInputStream(" path of the Excel file ");
				//Identifying workBook in the file
				XSSFWorkbook book = new XSSFWorkbook(file);
				//identifying the sheet in the Workbook
				XSSFSheet sheet = book.getSheet("SheetName");
				//identifying no of active rows in the sheet
				int count=sheet.getLastRowNum();
				for(int i=0; i<count; i++) {
					Row newrow =sheet.createRow(i);
					int cellCount=newrow.getLastCellNum();
					for(int j=0; j<cellCount;j++) {
						Cell newcell=row.createCell(j);
						newcell.setCellValue("");
					}
				}	
				
				//SCREENSHOT
				File Variable =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(Variable, new File("./ApplicationScreenShots/Screenshot.png"));//destination file
				
				//MouseHoverOperation
				Actions mouseHover = new Actions(driver);
				mouseHover.moveToElement(variablename2).build().perform();
				//keyboard Actions
				mouseHover.sendKeys(Keys.ENTER).build().perform();
				
				//Maximizing the browser
				driver.manage().window().maximize();
				
				//Select operation
				Select select = new Select(driver.findElement(By.id("")));
				select.selectByVisibleText("");
				select.selectByIndex(0);
				select.selectByValue("");
				select.deselectByIndex(0);
				select.deselectByValue("");
				select.deselectByVisibleText("");
				select.deselectAll();//used to desect all the selected optional values
				
				
				//Switch into the frame of the webpage
				driver.switchTo().frame(webElement);
				driver.switchTo().defaultContent();//to get out of the frame
				
				//Drag and Drop operation
				Actions action = new Actions(driver);
				action.dragAndDrop(variablename1, variablename2).build().perform();//variablename1-src element variablename2-destinationElement
				
				//Handling Alerts
				Alert alert = driver.switchTo().alert();
				alert.accept();//accepting the ok button in the alert window
				alert.dismiss();//used to work with cancel button
				alert.sendKeys("");//sending testdata into the alert window
				
				//Exception handling
				try {
					
				}
				catch(Exception e) {// e- can be any variable
					
				}
				
				//AutoIT Script
				
				WinWaitActive("Open")
				ControlSend("Open","","Edit1","C:\Users\HP\OneDrive\Desktop\OrangeHRM\OrangeHRMApplication_DDT\EmployeePhotographs\Sannyu.PNG")
				ControlClick("Open","","Button1")
				
				//Attatching photographs
				java.lang.Runtime.getRuntime().equals("path of autoIT Script");
				
				//identifying the properties file -since the properties of the Element are stored in it
				FileInputStream propertiesFile = new FileInputStream(" Path of the properties File ");
				Properties properties = new Properties();
				properties.load(propertiesFile);
				
				By elementProperty = By.id(properties.getProperty(" "));//property of an Element is identified and assigned to a variable
				
				//XPATH SYNTAX
				
				//tagName[@attribute='attributeValue']
				
				//XPATH SYNTAX - with more than one attribute
				
				1.//tagName[@attribute1='attributeValue1'][@attribute2='atttributeValue2']...
				2.//tagName[@attribute1='attributevalue1' and @attribute='attributeValue2' and @attribute3='atttributeValue3' and ......]
				
				//XPATH SYNTAX - using text()
				
				1.//tagName[text()='textvalue']
				
				//XPATH SYNTAX - using contains
				
				1.//tagName[contains(text(),'partialTextValue']
				2.//tagname[contains(@attribute,'partialvalue')]
				
				//Xpath expression creation based on properties of Element
				
				1) starts-with()
                    Syntax-
                    //*[starts-with(@attribute,'starting part of value which does not change')]
				
				2)ends-with()
                     Syntax-
                     //*[ends-with(@attribute,'ending part of the value which does not change')]
                     
                3)contains()
                     Syntax-
                     //*[contains(@attribute,'some part of value which does not change')]
                     
               //PageLoad
                     
                     driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
                
                //Implicit Wait
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                
                //Explicit Wait
                WebDriverWait wait = new WebDriverWait(30, TimeUnit.SECONDS);
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementProperty));
                //Delete All cookies
                driver.manage().deleteAllCookies();
				
				
				
				
		
	
}
}