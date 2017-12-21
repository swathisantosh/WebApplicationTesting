package com.KeywordDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewToursLoginTest {
	
	FirefoxDriver driver;
	@BeforeTest
		public void setup()
	{
		driver=new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
	}
	
	@Test
		public void NewtuorsLogin() throws IOException
		{
		FileInputStream file=new FileInputStream("C:\\Users\\kowth\\Desktop\\SwathiSelenium\\WebAutomationSelenium\\NewToursLogin.properties");
		Properties pr=new Properties();
		pr.load(file);
		
		driver.findElement(By.name(pr.getProperty("UserName"))).sendKeys("tutorial");
		
		driver.findElement(By.name(pr.getProperty("Password"))).sendKeys("tutorial");
		driver.findElement(By.name(pr.getProperty("SignIn"))).click();
		
		String ExpectedText = "your destination city";
		
		String ActualText=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font")).getText();
		
		if(ActualText.contains(ExpectedText))
		{
			System.out.println("LOgIn Successful -- PASS");
		}
		else
		{
			System.out.println("LogIn Failed -- FAIL");
		}
		}
@AfterTest
public void teardown()
{
	driver.close();
}
}
