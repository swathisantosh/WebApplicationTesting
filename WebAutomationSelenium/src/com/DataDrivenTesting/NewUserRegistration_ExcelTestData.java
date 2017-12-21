package com.DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewUserRegistration_ExcelTestData {

	
	FirefoxDriver driver;

	@BeforeTest
	public void setUp()
	{
		 driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void registerClick()
	{
		driver.findElementByLinkText("REGISTER").click();
	}
	@Test(priority=2)
	public void registerUser() throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\kowth\\Desktop\\UserRegistrationTestData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int rowcount=sheet.getLastRowNum();
		
		
		for(int i=1;i<=rowcount;i++)
		{
			Row r=	sheet.getRow(i);
					
		driver.findElementByName("firstName").sendKeys(r.getCell(0).getStringCellValue());
		driver.findElementByName("lastName").sendKeys(r.getCell(1).getStringCellValue());
		double d=r.getCell(2).getNumericCellValue();
		long d1=(long)d;
		String phone=Long.toString(d1);
		driver.findElementByName("phone").sendKeys(phone);
		driver.findElementByName("userName").sendKeys(r.getCell(3).getStringCellValue());
		driver.findElementByName("address1").sendKeys(r.getCell(4).getStringCellValue());
		driver.findElementByName("city").sendKeys(r.getCell(5).getStringCellValue());
		driver.findElementByName("state").sendKeys(r.getCell(6).getStringCellValue());
		
		double p= r.getCell(7).getNumericCellValue();
		long p1=(long)p;
		String postcode=Long.toString(p1);
		driver.findElementByName("postalCode").sendKeys(postcode);
		driver.findElementByName("country").sendKeys(r.getCell(8).getStringCellValue());
		driver.findElementByName("email").sendKeys(r.getCell(9).getStringCellValue());
		driver.findElementByName("password").sendKeys(r.getCell(10).getStringCellValue());
		driver.findElementByName("confirmPassword").sendKeys(r.getCell(11).getStringCellValue());
		driver.findElementByName("register").click();
		
		String ActualString=driver.findElementByXPath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b").getText();
		String ExpectedString= r.getCell(9).getStringCellValue();
		
		if(ActualString.contains(ExpectedString))
		{
			System.out.println("UserName valid- PASSED");
			Cell c=r.createCell(12);
			c.setCellValue("UserName valid- PASSED");
			
		}
		else
		{
			System.out.println("UserName valid- FAILED");
			Cell c=r.createCell(12);
			c.setCellValue("UserName valid- FAILED");
		}
		FileOutputStream file1= new FileOutputStream("C:\\Users\\kowth\\Desktop\\UserRegistrationTestData.xlsx");
		workbook.write(file1);
		
		
		driver.navigate().back();
		
		}
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
}