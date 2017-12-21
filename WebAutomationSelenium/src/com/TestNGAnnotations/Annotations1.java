package com.TestNGAnnotations;

import org.testng.annotations.Test;

public class Annotations1 
{

	@Test(priority=1)
	public void BrowserLaunch()
	{
		System.out.println("Launching FireFox Browser");
	}
	
	
	@Test(priority=2)
	public void LogIN()
	{
		System.out.println("Testing LogIN Funtionality");
	}
	
	@Test(enabled=false)
	public void Compose()
	{
		System.out.println("Testing COmpose Mail Functionality");
	}
	
	
}
