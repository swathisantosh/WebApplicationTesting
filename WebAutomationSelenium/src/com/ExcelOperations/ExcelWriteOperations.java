package com.ExcelOperations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriteOperations {

	public static void main(String[] args) throws IOException {
		FileInputStream file=new FileInputStream("C:\\Users\\kowth\\Desktop\\TestData.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet sheet= workbook.getSheet("Sheet1");
		Row r=sheet.createRow(5);
		Cell c=r.createCell(0);
		c.setCellValue("testdata");
		FileOutputStream file1=new FileOutputStream("C:\\Users\\kowth\\Desktop\\TestData.xlsx");
		workbook.write(file1);

	}

}