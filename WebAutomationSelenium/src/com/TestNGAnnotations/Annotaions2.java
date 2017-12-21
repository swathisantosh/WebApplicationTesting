package com.TestNGAnnotations;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotaions2 
{

	
	@BeforeTest
	public void BrowserLaunchAndNavigateToGmail()
	{
		System.out.println("Launching Browser and Navigating to Gmail Application");
	}
	
	@Test(priority=1)
	
	public void InBox()
	{
		System.out.println("Tesing InBox Functionality");
	}
	
	@Test(priority=2)
	public void SentMail()
	{
		System.out.println("Testing SentMain Functionality");
	}
	
	@AfterTest
	public void ApplicationClose()
	{
		System.out.println("Closing Application");
	}
}
