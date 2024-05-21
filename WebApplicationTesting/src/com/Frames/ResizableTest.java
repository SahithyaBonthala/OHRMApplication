package com.Frames;

 import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ResizableTest extends BaseTest {
	
	public void dragAndDropOperation()
	{
		
		By jQueryFrameProperty = By.className("demo-frame");
		WebElement jQueryFrame = driver.findElement(jQueryFrameProperty);
		
		driver.switchTo().frame(jQueryFrame);
		
		By dragMeToMYTargetPropperty = By.id("draggable");
		WebElement dragMeToMyTarget = driver.findElement(dragMeToMYTargetPropperty);
		String dargMeToMyTarget_Text = dragMeToMyTarget.getText();
		
		System.out.println(" The Text of the WebElement is : - " + dargMeToMyTarget_Text);
		
		By droppableProperty = By.id("droppable");
		WebElement droppable = driver.findElement(droppableProperty);
		String droppable_Text = droppable.getText();
		
		System.out.println(" The Text of The Droppable WebElement is : - " + droppable_Text);
		
		Actions action = new Actions(driver);
		action.dragAndDrop(dragMeToMyTarget, droppable).build().perform();
		
		driver.switchTo().defaultContent();
		
	
	}
	
	public void resizableTest()
	{
		
		By resizableProperty = By.linkText("Resizable");
		WebElement resizable = driver.findElement(resizableProperty);
		resizable.click();
		
		System.out.println(" the Title of The Resizable WebPage is : - " + driver.getTitle());
	}
	
	public static void main(String[] args) {
		
		ResizableTest test = new ResizableTest();
		test.applicationLaunch();
		test.dragAndDropOperation();
		test.resizableTest();
		test.applicationClose();
	}

}
