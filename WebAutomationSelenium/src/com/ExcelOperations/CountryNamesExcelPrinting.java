package com.ExcelOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CountryNamesExcelPrinting {

	public static void main(String[] args) throws IOException {

		FirefoxDriver driver = new FirefoxDriver();
		  driver.get("http://newtours.demoaut.com");
		  
		  driver.manage().window().maximize();
		  
		  driver.findElement(By.linkText("REGISTER")).click();
		  
		  WebElement Country=driver.findElement(By.name("country"));
		  
		  List<WebElement>CountryNames=Country.findElements(By.tagName("option"));
		  
		  System.out.println(CountryNames.size());
		  
		  for(int i=0;i<CountryNames.size();i++)
		  {
		   String CountryName=CountryNames.get(i).getText();
		  
			FileInputStream file=new FileInputStream("C:\\Users\\kowth\\Desktop\\CountryNames.xlsx");
			XSSFWorkbook workbook= new XSSFWorkbook(file);
			XSSFSheet sheet= workbook.getSheet("Sheet1");
			Row r=sheet.createRow(i);
			Cell c=r.createCell(0);
			c.setCellValue(CountryName);
			FileOutputStream file1=new FileOutputStream("C:\\Users\\kowth\\Desktop\\CountryNames.xlsx");
			workbook.write(file1);
		  }

		  driver.close();

	}

}
