package com.ScreeshotTesting;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.TakesScreenshot;

public class Screesnshot_NewTour_HomeLinks {

	public static void main(String[] args) throws IOException {

		FirefoxDriver driver = new FirefoxDriver();
		  driver.get("http://newtours.demoaut.com");
		  
		  driver.manage().window().maximize();
		  
		  List<WebElement>links = driver.findElements(By.tagName("a"));
		  System.out.println(links.size());
		  
		  for(int i=0;i<links.size();i++)
		  {
		   String linkName=links.get(i).getText();
		   System.out.println(linkName);
		   
		   links.get(i).click();
		   
		   System.out.println(driver.getTitle());
		   System.out.println(driver.getCurrentUrl());
		   System.out.println();
		   Sleeper.sleepTightInSeconds(5);
		   
		  			   
			File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 String dstnFile=  "C:\\Users\\kowth\\Desktop\\ScreenShots\\NewTour\\screen"+i+".png";
			
			FileUtils.copyFile(srcFile,new File(dstnFile));
			     
		   
		   driver.navigate().back();
		   links = driver.findElements(By.tagName("a"));   
		  }
		  
		  driver.close();
	}

}
