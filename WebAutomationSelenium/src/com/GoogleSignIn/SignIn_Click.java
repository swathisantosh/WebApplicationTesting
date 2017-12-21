package com.GoogleSignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SignIn_Click {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirefoxDriver driver= new FirefoxDriver();
driver.get("http://google.com");
driver.findElement(By.id("gb_70")).click();

//driver.findElement(By.linkText("Sign in")).click();

System.out.println(driver.getTitle());
System.out.println(driver.getCurrentUrl());

driver.close();
	}

}
