package com.TestNGAnnotations;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewToursRegister {
	
	FirefoxDriver driver;

	@BeforeTest
	public void setUp()
	{
		 driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		
		driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void register()
	{
		driver.findElementByLinkText("REGISTER").click();	
	}
	@Test(priority=2)
	public void registerUser()
	{
		
		driver.findElementByName("firstName").sendKeys("Swathi");
		driver.findElementByName("lastName").sendKeys("Test");
		driver.findElementByName("phone").sendKeys("98989898");
		driver.findElementByName("userName").sendKeys("stest@gmail.com");
		driver.findElementByName("address1").sendKeys("address 1");
		driver.findElementByName("city").sendKeys("stest");
		driver.findElementByName("state").sendKeys("Telangana");
		driver.findElementByName("postalCode").sendKeys("500042");
		driver.findElementByName("country").sendKeys("INDIA");
		driver.findElementByName("email").sendKeys("stest1");
		driver.findElementByName("password").sendKeys("stest");
		driver.findElementByName("confirmPassword").sendKeys("stest");
		driver.findElementByName("register").click();
		
		String ActualString=driver.findElementByXPath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b").getText();
		String ExpectedString= "stest1.";
		
		if(ActualString.endsWith(ExpectedString))
		{
			System.out.println("UserName valid- PASSED");
		}
		else
		{
			System.out.println("UserName valid- FAILED");
		}
		
	}
	
	@AfterTest
	public void tearDown()
	{
	//need to write signout..
		driver.close();
	}
	

}
