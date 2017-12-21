package com.DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewToursLinks_ExcelDataTesting {

	FirefoxDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver = new FirefoxDriver();
		  driver.get("http://newtours.demoaut.com");
		  
		  driver.manage().window().maximize();

	}
	
	@Test
	public void NewtoursAllLinks() throws IOException
	{
		
		 List<WebElement>links = driver.findElements(By.tagName("a"));
		  System.out.println(links.size());
		  FileInputStream file=new FileInputStream("C:\\Users\\kowth\\Desktop\\NewTourLinks.xlsx");
			XSSFWorkbook workbook=new XSSFWorkbook(file);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
				Row header= sheet.createRow(0);
				header.createCell(0).setCellValue("Link Name");
				header.createCell(1).setCellValue("HREF Attribute");
				header.createCell(2).setCellValue("Actual/Current URL");
				header.createCell(3).setCellValue("Result");
				
		  for(int i=0;i<links.size();i++)
		  {
		   String linkName=links.get(i).getText();
		   System.out.println(linkName);
		   Row r=sheet.createRow(i+1);
		   r.createCell(0).setCellValue(linkName);
		   
		   
		   String hrefValue=links.get(i).getAttribute("href");
		   
		   System.out.println(hrefValue);
		   r.createCell(1).setCellValue(hrefValue);
		   links.get(i).click();
		   String currentURL=driver.getCurrentUrl();
		   System.out.println(currentURL);
		   r.createCell(2).setCellValue(currentURL);
		   System.out.println();
		   
		   if(currentURL.equals(hrefValue))
		   {
			   System.out.println("URL Matched--PASSED");
			   r.createCell(3).setCellValue("URL Matched--PASSED");
		   }
		   else
		   {
			   System.out.println("URL NOT Matched--FAILED");
			   r.createCell(3).setCellValue("URL Matched--FAILED");  
		   }
		   
		   	   
		   
		   driver.navigate().back();
		   links = driver.findElements(By.tagName("a"));   
		  }
		  FileOutputStream file1= new FileOutputStream("C:\\Users\\kowth\\Desktop\\NewTourLinks.xlsx");
			workbook.write(file1);
		 
	}

	@AfterTest

	public void tearDown()
	{
		driver.close();
	}
	
	
	
}
