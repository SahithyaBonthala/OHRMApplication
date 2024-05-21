package com.TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annatation1 {
	
@Test(priority=2)
	
	public void logInTest()
	{
		System.out.println(" Gmail LogIn Functionality Test Successful ");
	}
	
	@BeforeMethod
	public void applicationLaunch()
	{
		System.out.println(" Gmail Application Launch Successful ");
	}
	
	@Test(priority=3)
	public void ComposeMailTest()
	{
		System.out.println(" Compose Mail Functionality Test Successful ");
	}
	
	@Test(priority=4)
	public void inboxTest()
	{
		System.out.println(" Gmail Inbox Functionality Test Successful");
	}
	
	@Test(enabled=false)
	public void draftsTest()
	{
		System.out.println(" Gmail Drafts Functionality Test Successful");
	}
	
	@Test(priority=7)
	public void sentMail()
	{
		System.out.println(" Gmail SentMail Functionality Test Succesful");
	}
	
	@AfterMethod
	public void applicationClose()
	{
		System.out.println(" Gmail Application Close Successful");
	}


}
