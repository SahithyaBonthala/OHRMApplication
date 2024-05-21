package com.DatePicker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hslf.examples.DataExtraction;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class Abhibus {
	
	static WebDriver driver;
	String applicationUrl = "https://www.abhibus.com/";
	
	@BeforeTest	
	public void applicationLaunch() throws IOException {
				driver = new ChromeDriver();
		driver.get(applicationUrl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		File Variable =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(Variable, new File("./ApplicationScreenShots/Screenshot.png"));
		//driver.manage().window().fullscreen();
		driver.manage().window().maximize();
		
	}
	
	FileInputStream file;
	XSSFWorkbook book;
	XSSFSheet sheet;
	//Row row = sheet.getRow(0);
	Row row;
	String cell ;
	Object cell1 ;
	Object cell2 ;
	String exp_MonthYear = "June 2024";
	String exp_Month = "cell";
	String exp_Year = "cell1";
	String exp_Day = "cell2";
	
	@Test
	public void application() throws InterruptedException, IOException {
		
		file = new FileInputStream("./src/com/Excell/Book 2.xlsx");
		book = new XSSFWorkbook(file);
		sheet = book.getSheet("testDataSheet");
		row = sheet.getRow(0);
		cell =row.getCell(0).getStringCellValue();
	 cell1 =row.getCell(1).getCellType();
		 cell2 =row.getCell(2).getStringCellValue();
		
		
		String cell3 =row.getCell(3).getStringCellValue();
		By fromProperty = By.cssSelector("[type=\"text\"]");
		driver.findElement(fromProperty).sendKeys("cell3");
		
		Thread.sleep(5000);
	
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
		
		String cell4 =row.getCell(4).getStringCellValue();
		action.sendKeys("cell4");
		////*[@id="jaurney-date"]/div/div/div/div[2]/input
		action.sendKeys(Keys.TAB).build().perform();
		By calenderProperty = By.xpath("//*[@id=\"jaurney-date\"]/div/div/div/div[2]/input");
		driver.findElement(calenderProperty).click();

		String act_MonthYear=driver.findElement(By.cssSelector("[style=\"text-align: center;\"]")).getText();
		System.out.println(act_MonthYear);
		while(true) {
			 act_MonthYear=driver.findElement(By.cssSelector("[style=\"text-align: center;\"]")).getText();
			
			String act_Month= driver.findElement(By.xpath("//*[@id=\"jaurney-date\"]/div/div[2]/div[1]/div[2]/span[1]")).getText();
			 System.out.println(act_Month);
			String act_Year = driver.findElement(By.cssSelector(".year")).getText();
			System.out.println(act_Year);
			// System.out.println(act_MonthYear);
			 if(act_Month.equals(exp_Month) && act_Year.equals(exp_Year)) {
				 break;
			 }else {
				 driver.findElement(By.xpath("//*[@id=\"jaurney-date\"]/div/div[2]/div[1]/div[3]/span")).click();
			 }
			
		}
		driver.findElement(By.cssSelector("[data-date=\"16\"]")).click();
	}

}
