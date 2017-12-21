package com.HybridTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTours_UserRegistration {

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
		FileInputStream file1=new FileInputStream("C:\\Users\\kowth\\Desktop\\SwathiSelenium\\WebAutomationSelenium\\NewToursLogin.properties");
		Properties pr=new Properties();
		pr.load(file1);
		
		for(int i=1;i<=rowcount;i++)
		{
			Row r=	sheet.getRow(i);
					
		driver.findElementByName(pr.getProperty("FirstName")).sendKeys(r.getCell(0).getStringCellValue());
		driver.findElementByName(pr.getProperty("LastName")).sendKeys(r.getCell(1).getStringCellValue());
		double d=r.getCell(2).getNumericCellValue();
		long d1=(long)d;
		String phone=Long.toString(d1);
		driver.findElementByName(pr.getProperty("Phone")).sendKeys(phone);
		driver.findElementByName(pr.getProperty("Email")).sendKeys(r.getCell(3).getStringCellValue());
		driver.findElementByName(pr.getProperty("Address1")).sendKeys(r.getCell(4).getStringCellValue());
		driver.findElementByName(pr.getProperty("City")).sendKeys(r.getCell(5).getStringCellValue());
		driver.findElementByName(pr.getProperty("State")).sendKeys(r.getCell(6).getStringCellValue());
		
		double p= r.getCell(7).getNumericCellValue();
		long p1=(long)p;
		String postcode=Long.toString(p1);
		driver.findElementByName(pr.getProperty("PostalCode")).sendKeys(postcode);
		driver.findElementByName(pr.getProperty("Country")).sendKeys(r.getCell(8).getStringCellValue());
		driver.findElementByName(pr.getProperty("UserName")).sendKeys(r.getCell(9).getStringCellValue());
		driver.findElementByName(pr.getProperty("Password")).sendKeys(r.getCell(10).getStringCellValue());
		driver.findElementByName(pr.getProperty("ConfirmPassword")).sendKeys(r.getCell(11).getStringCellValue());
		driver.findElementByName(pr.getProperty("Register")).click();
		
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
		FileOutputStream file2= new FileOutputStream("C:\\Users\\kowth\\Desktop\\UserRegistrationTestData.xlsx");
		workbook.write(file2);
		
		
		driver.navigate().back();
		
		}
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
}