package com.LinksTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ValidatingHrefAttribute_Register_NewToursAppl {

	public static void main(String[] args) {

		  FirefoxDriver driver = new FirefoxDriver();
		  driver.get("http://newtours.demoaut.com");
		  
		  driver.manage().window().maximize();
		  
		  String ExpectedURL=driver.findElement(By.linkText("REGISTER")).getAttribute("href");
		  
		  driver.findElement(By.linkText("REGISTER")).click();
		  
		  String ActualURL=driver.getCurrentUrl();
		  
		  System.out.println(ExpectedURL);
		  System.out.println(ActualURL);
		  
		  if(ActualURL.contains(ExpectedURL))
		  {
		   System.out.println("URL Matched -- PASS");
		  }
		  else
		  {
		   System.out.println("URL not matched -- FAIL");
		  }

		  driver.close();
	}

}
