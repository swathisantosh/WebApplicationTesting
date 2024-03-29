package com.DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewToursLinks_FromDataSheet {

FirefoxDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver = new FirefoxDriver();
		  driver.get("http://newtours.demoaut.com");
		  
		  driver.manage().window().maximize();

	}
	
	@Test
	public void NewtoursLinks() throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\kowth\\Desktop\\NewTourLinksDataSheet.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int rowcount=sheet.getLastRowNum();
		Row r=sheet.getRow(0);
		
		
			
		
		for(int i=1;i<=rowcount;i++)
		{
			try
			{
			 r=	sheet.getRow(i);
			String LinkName=r.getCell(0).getStringCellValue();
			driver.findElement(By.linkText(LinkName)).click();
			String expectedURL=r.getCell(1).getStringCellValue();
			String currentURL=driver.getCurrentUrl();
			 
			   r.createCell(2).setCellValue(currentURL);
			if(expectedURL.equals(currentURL))
			{
				 System.out.println("URL Matched--PASSED");
				   r.createCell(3).setCellValue("URL Matched--PASSED");
			}
			else
			{
				 System.out.println("URL NOT Matched--FAILED");
				   r.createCell(3).setCellValue("URL NOT Matched--FAILED");
			}
			
			 FileOutputStream file1= new FileOutputStream("C:\\Users\\kowth\\Desktop\\NewTourLinksDataSheet.xlsx");
			workbook.write(file1);
			driver.navigate().back();
		}
		
		catch(Exception e)
		{
			r.createCell(3).setCellValue("LinkName Not found");
			 FileOutputStream file1= new FileOutputStream("C:\\Users\\kowth\\Desktop\\NewTourLinksDataSheet.xlsx");
				workbook.write(file1);
			//driver.navigate().back();
				 driver.get("http://newtours.demoaut.com");
			
		}
		}
		
		
	}
}
