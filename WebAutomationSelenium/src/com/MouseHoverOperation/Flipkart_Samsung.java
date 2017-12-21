package com.MouseHoverOperation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Flipkart_Samsung {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  FirefoxDriver driver = new FirefoxDriver();
		  driver.get("http://livetech.in");
		  
		  driver.manage().window().maximize();
		  
		  Actions action = new Actions(driver);
		  
		  WebElement AboutUs=driver.findElement(By.linkText("About Us"));
		  
		  action.moveToElement(AboutUs).perform();
		  
		  driver.findElement(By.linkText("Company")).click();
		  
		  driver.close();
	}

}
