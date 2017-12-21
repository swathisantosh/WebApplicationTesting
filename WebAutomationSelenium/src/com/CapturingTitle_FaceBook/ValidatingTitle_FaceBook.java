package com.CapturingTitle_FaceBook;

import javax.naming.InterruptedNamingException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ValidatingTitle_FaceBook {

	public static void main(String[] args)
	{
		
		//System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		//	ChromeDriver driver = new ChromeDriver();
		
		//System.setProperty("webdriver.edge.driver", "c:\\MicrosoftWebDriver.exe");
		//EdgeDriver driver = new EdgeDriver();
		
	//	System.setProperty("webdriver.ie.driver","c:\\IEDriverServer..exe");
	//	InternetExplorerDriver driver = new InternetExplorerDriver();
		
		//System.setProperty("webdriver.gecko.driver", "c:\\geckodriver.exe");
			FirefoxDriver driver = new FirefoxDriver();
		  driver.get("http://facebook.com");
		  
		  System.out.println(driver.getTitle());
		  
		  String ExpectedTitle="Facebook � log in or sign up";
		  System.out.println(ExpectedTitle);
		  
		  String ActualTitle=driver.getTitle();
		  
		  if(ActualTitle.equals(ExpectedTitle))
		  {
		   System.out.println("Title Matched -- PASS");
		  }
		  else
		  {
		   System.out.println("Title Not Matched -- FAIL");
		  }
		  
		  System.out.println();
		  
		  String ExpectedUrl="facebook.com";
		  System.out.println(ExpectedUrl);
		  
		  String ActualUrl=driver.getCurrentUrl();
		  System.out.println(ActualUrl);
		  
		  if(ActualUrl.contains(ExpectedUrl))
		  {
		   System.out.println("URL matched -- PASS");
		  }
		  else
		  {
		   System.out.println("URL not matched -- FAIL");
		  }
		  
		  driver.close();

	}

}
