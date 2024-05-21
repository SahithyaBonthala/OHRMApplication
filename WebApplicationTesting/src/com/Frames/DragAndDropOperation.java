package com.Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropOperation extends BaseTest {
	
	public void dragAndDropOpertion()
	{
		
		By jQueryFrameProperty = By.className("demo-frame");
		WebElement jQueryFrame = driver.findElement(jQueryFrameProperty);
		
		driver.switchTo().frame(jQueryFrame);
		
		By dragMeToMyTargetProperty = By.id("draggable");
		WebElement dragMeToMyTarget = driver.findElement(dragMeToMyTargetProperty);
		String dragMeToMyTarget_Text = dragMeToMyTarget.getText();
		
		System.out.println(" The Text of Draggable WebElement is : - " + dragMeToMyTarget_Text);
		
		By droppableProperty = By.id("droppable");
		WebElement droppable = driver.findElement(droppableProperty);
		String droppableText = droppable.getText();
		
		System.out.println("The Text of Droppable WebElement is : - " + droppableText);
		
		Actions action = new Actions(driver);
		action.dragAndDrop(dragMeToMyTarget,droppable).build().perform();
		
		
	}
	
	public static void main(String[] args) {
		
		DragAndDropOperation dragAndDrop = new DragAndDropOperation();
		dragAndDrop.applicationLaunch();
		dragAndDrop.dragAndDropOpertion();
		//dragAndDrop.applicationClose();
	}
	
	

}
