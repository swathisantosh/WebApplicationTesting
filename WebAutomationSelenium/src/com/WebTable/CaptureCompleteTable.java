package com.WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CaptureCompleteTable {
	
	public static void main(String[] args)
	{
		FirefoxDriver driver = new FirefoxDriver();
		  driver.get("https://www.timeanddate.com/worldclock/");
		  
		  driver.manage().window().maximize();
		  
		  // html/body/div[1]/div[8]/section[2]/div[1]/table/tbody/tr[1]/td[1]
		  // html/body/div[1]/div[8]/section[2]/div[1]/table/tbody/tr[36]/td[8]
		  
		  String part1="html/body/div[1]/div[8]/section[2]/div[1]/table/tbody/tr[";
		  String part2="]/td[";
		  String part3="]";
		  
		  for(int i=1;i<=36;i++)
		  {
		   for(int j=1;j<=8;j++)
		   {
		    String testData=driver.findElement(By.xpath(part1+i+part2+j+part3)).getText();
		    System.out.print(testData+" ");
		   }
		   System.out.println();
		  }
		  
		  driver.close();

	}

}
