package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CommonActions.CommonAction;
import PageObjectModel.LoginPOM;

public class LoginPage extends CommonAction {
	/**
	 * username -user@phptravels.com
	 * password -demouser
	 * URL - https://phptravels.com/demo/
	 * https://phptravels.org/clientarea.php
	 * @throws IOException 
	 * 
	 */
	
	@BeforeTest
	public void setData() {
		
		testName ="LoginLogout";
		testDesc ="Test lofin for positive values";
		testAuthor ="Hari";
		testCategory ="functional";
		
		
	}
	
	@Test
	public void login() throws Exception {
		
		
		
		//System.setProperty("webdriver.chrome.driver", "/Users/krishnakumar/Downloads/ChromeDriverLatest/ChromeDriver");
	//	WebDriver driver = new ChromeDriver();
		
		
		
		//driver.get("http://demowebshop.tricentis.com/login");
		
		
		////LoginPOM loginpom = new LoginPOM();
		
		 
		
		PageFactory.initElements(driver, LoginPOM.class);
		LoginPOM.username.sendKeys(properties.getProperty("username"));
		reportStep("username is entered succesfully","pass");
		LoginPOM.password.sendKeys("password");
		reportStep("Password is entered successfully","pass");
		LoginPOM.loginButton.click();
		reportStep("LoginButton is entered successfully","pass");
		
		
	//	LoginPOM loginpom = new LoginPOM();
		
	
	
	
		
		
		
		/*
		driver.findElement(By.id("Email")).sendKeys("Arun.Kumar@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("password");
		driver.findElement(By.xpath("//input[@type='submit'][@value='Log in']")).click();
		driver.findElement(By.linkText("Arun.Kumar@gmail.com")).click();
		*/
	}

	
	
	
	

}
