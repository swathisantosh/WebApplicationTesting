package com.TestNGAnnotations;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

public class Annotations3 
{

	
	@BeforeMethod
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
	
	@AfterMethod
	public void ApplicationClose()
	{
		System.out.println("Closing Application");
	}
	
	
	
}
