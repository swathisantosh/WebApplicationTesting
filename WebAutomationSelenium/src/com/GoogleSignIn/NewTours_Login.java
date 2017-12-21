package com.GoogleSignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewTours_Login {

	public static void main(String[] args) {

		  FirefoxDriver driver = new FirefoxDriver();
		  driver.get("http://newtours.demoaut.com");
		  
		  driver.findElement(By.name("userName")).sendKeys("tutorial");
		  driver.findElementByName("password").sendKeys("tutorial");
		  driver.findElement(By.name("login")).click();
		  
		  System.out.println(driver.getTitle());
		  System.out.println(driver.getCurrentUrl());
		  
		  driver.findElement(By.partialLinkText("SIGN-OF")).click();
		  driver.close();
	}

}
