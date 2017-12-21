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

public class Screenshot_TSRTC_HeaderLinks {
	public static void main(String[] args) throws InterruptedException, IOException
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
		   
		   HeaderLinks.get(i).click();
		   
		   System.out.println(driver.getTitle());
		   System.out.println(driver.getCurrentUrl());
		   System.out.println();
		   
		   driver.navigate().back();
		   
		   Thread.sleep(8000);
		   //Sleeper.sleepTightInSeconds(5);
		   File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		   String dstnFile=  "C:\\Users\\kowth\\Desktop\\ScreenShots\\TSRTC\\"+HeaderLinkName+".png";
			
			FileUtils.copyFile(srcFile,new File(dstnFile));

		    HeaderBlock=driver.findElement(By.className("menu-wrap"));
		    HeaderLinks=HeaderBlock.findElements(By.tagName("a"));
		   
		   
		  }
		  
		  driver.close();
	}
	}


