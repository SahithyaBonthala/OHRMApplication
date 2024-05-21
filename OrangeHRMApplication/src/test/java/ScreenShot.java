import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreenShot {
	
	static WebDriver driver;
	String applicationUrl = "https://www.abhibus.com/";
	//https://jqueryui.com/controlgroup/
	
	
	@Test	
	public void applicationLaunch() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./ChromeDriver/chromedriver.exe");
				driver = new ChromeDriver();
		driver.get(applicationUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		int x=driver.findElement(By.xpath("//*[@id=\"search-button\"]")).getLocation().getX();
		int y=driver.findElement(By.xpath("//*[@id=\"search-button\"]")).getLocation().getY();
		int width=driver.findElement(By.xpath("//*[@id=\"search-button\"]")).getSize().getWidth();
		int height=driver.findElement(By.xpath("//*[@id=\"search-button\"]")).getSize().getHeight();
		Thread.sleep(5000);
		//int x = search.getLocation().getX();
	//	int y = search.getLocation().getY();
		//int width = search.getSize().getWidth();
		// int height = search.getSize().getHeight(); 
		 
		 try {
			 File Variable =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 BufferedImage fullImg = ImageIO.read(Variable);
	            BufferedImage elementScreenshot = fullImg.getSubimage(x, y, width, height);
	            ImageIO.write(elementScreenshot, "png", Variable);
	            
	            File screenshotLocation = new File("C:\\Users\\HP\\OneDrive\\Desktop\\OrangeHRM\\OrangeHRMApplication\\ChromeDriver\\SearchScreenshot.png");
	            FileUtils.copyFile(Variable, screenshotLocation);
		 }catch(Exception e) {
			 System.out.println(e);
		 }
		
		//Files.copy(Variable, new File("./ApplicationScreenShots/Screenshot.png"));
		//driver.manage().window().fullscreen();
		
		
	}

}
