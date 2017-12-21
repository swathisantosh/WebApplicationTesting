package com.LinksTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Register_Vacations_BackToHome_NewToursAppl {

	public static void main(String[] args) {

		FirefoxDriver driver= new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		driver.manage().window().maximize();
		WebElement register =driver.findElement(By.linkText("REGISTER"));
		 register.click();
		 driver.findElement(By.linkText("Vacations")).click();

		 driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[4]/td/a/img")).click();
		 
		 driver.close();

	}

}
