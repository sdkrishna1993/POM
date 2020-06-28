package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumProgram {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver","/Users/krishnakumar/Downloads/ChromeDriverLatest/ChromeDriver");
		
		driver = new ChromeDriver();
		
		
		
	}
	
	@Test
	public void login() {
		
		driver.get("https://google.com");
	
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		
		driver.quit();
		
		
	}
	
	
	
	
		
		
			
			
		





}
		
		
		
	

	
	
	


