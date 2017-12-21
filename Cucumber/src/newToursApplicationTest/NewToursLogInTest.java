package newToursApplicationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class NewToursLogInTest 
{
	public FirefoxDriver driver;

	@Given("^Open Firefox Browser and Navigate to NewTours Application$")
	public void Open_Firefox_Browser_and_Navigate_to_NewTours_Application() throws Throwable
	{
	   driver=new FirefoxDriver();
	   driver.get("http://newtours.demoaut.com");
	}

	@When("^User enters Valid UserName and Password and perform Click operation on SignIn Button$")
	public void User_enters_Valid_UserName_and_Password_and_perform_Click_operation_on_SignIn_Button() throws Throwable
	{
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		driver.findElement(By.name("password")).sendKeys("tutorial");
		driver.findElement(By.name("login")).click();
	}

	@Then("^User should be successfully LogIn to the Application and SignOff$")
	public void User_should_be_successfully_LogIn_to_the_Application_and_SignOff() throws Throwable
	{
	 driver.findElement(By.linkText("SIGN-OFF")).click();
	}

	@Then("^User should close the Browser$")
	public void User_should_close_the_Browser() throws Throwable
	{
	driver.close();
	}
}
