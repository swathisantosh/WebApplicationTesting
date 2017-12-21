package com.LinksTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TSRTC_HeaderLinks_HrefValidation {
	public static void main(String[] args) throws InterruptedException
	{
		FirefoxDriver driver = new FirefoxDriver();
		  driver.get("http://www.tsrtconline.in/oprs-web/");
		  
		  WebElement HeaderBlock=driver.findElement(By.className("menu-wrap"));
		  List<WebElement>HeaderLinks=HeaderBlock.findElements(By.tagName("a"));
		  
		  System.out.println(HeaderLinks.size());
		  
		  for(int i=0;i<HeaderLinks.size();i++)
		  {
		   String HeaderLinkName=HeaderLinks.get(i).getText();
		   System.out.println(HeaderLinkName);
		   
		   String ExpectedResult=HeaderLinks.get(i).getAttribute("href");
		   System.out.println(ExpectedResult);
		      
		   HeaderLinks.get(i).click();
		   
		  String ActualResult= driver.getCurrentUrl();
		   System.out.println(ActualResult);
		   
		   if(ActualResult.equals(ExpectedResult))
		   {
			   System.out.println(HeaderLinkName+" URL Matched -- PASS");
		   }
		   else
		   {
		    System.out.println(HeaderLinkName+" URL not matched -- FAIL");
		   }
		   
		   
		   driver.navigate().back();
		   
		   Thread.sleep(5000);
		  
		   
		    HeaderBlock=driver.findElement(By.className("menu-wrap"));
		    HeaderLinks=HeaderBlock.findElements(By.tagName("a"));
		   
		   
		  }
		  
		  driver.close();
	}

}
