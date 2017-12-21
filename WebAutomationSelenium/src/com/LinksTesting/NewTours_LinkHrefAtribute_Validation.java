package com.LinksTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewTours_LinkHrefAtribute_Validation {

	public static void main(String[] args) {

		FirefoxDriver driver = new FirefoxDriver();
		  driver.get("http://newtours.demoaut.com");
		  
		  driver.manage().window().maximize();
		  
		  List<WebElement>links = driver.findElements(By.tagName("a"));
		  System.out.println(links.size());
		  
		  for(int i=0;i<links.size();i++)
		  {
		   String linkName=links.get(i).getText();
//		   System.out.println(linkName);
		   String ExpectedResult=links.get(i).getAttribute("href");
		   System.out.println(ExpectedResult);
		   links.get(i).click();
		   
		   //System.out.println(driver.getTitle());
		   //System.out.println(driver.getCurrentUrl());
		   //System.out.println();
		   String ActualResult=driver.getCurrentUrl();
		   System.out.println(ActualResult);
		   
		   if(ActualResult.equals(ExpectedResult))
		   {
			   System.out.println(linkName+"URL Matched -- PASS");
		   }
		   else
		   {
		    System.out.println(linkName+"URL not matched -- FAIL");
		   }
		   
		   driver.navigate().back();
		   links = driver.findElements(By.tagName("a"));   
		  }
		  
		  driver.close();

	}

}
