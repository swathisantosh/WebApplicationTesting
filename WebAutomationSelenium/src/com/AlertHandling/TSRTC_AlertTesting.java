package com.AlertHandling;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class TSRTC_AlertTesting
{

	public static void main(String[] args)
	{
		FirefoxDriver driver =new FirefoxDriver();
		driver.get("http://tsrtconline.in");
		driver.manage().window().maximize();
		driver.findElement(By.id("searchBtn")).click();
		
		Alert alt = driver.switchTo().alert();
		
		Sleeper.sleepTightInSeconds(10);
		
		System.out.println(alt.getText());
		alt.accept();
		
		//alt.dismiss();
		
		//alt.sendKeys("Hello");
		
		driver.close();
		
		
		
	}
	
	
}
