package com.WebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DynamicWebTable {

	public static void main(String[] args) {
		
		FirefoxDriver driver = new FirefoxDriver();
		  driver.get("https://www.timeanddate.com/worldclock/");
		  
		  driver.manage().window().maximize();
		  
		  WebElement table=driver.findElement(By.xpath("html/body/div[1]/div[8]/section[2]/div[1]/table"));
		  
		  List<WebElement>row=table.findElements(By.tagName("tr"));
		  
		  for(int i=0;i<row.size();i++)
		  {
		   List<WebElement>col=row.get(i).findElements(By.tagName("td"));
		   
		   for(int j=0;j<col.size();j++)
		   {
		    String testData=col.get(j).getText()+" ";
		    System.out.print(testData);
		   }
		   System.out.println();
		  }
		  driver.close();

	}

}
