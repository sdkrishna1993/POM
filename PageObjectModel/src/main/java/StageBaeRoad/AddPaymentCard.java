package StageBaeRoad;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddPaymentCard {
	
	WebDriver driver;

	@BeforeMethod
	public void setup() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/krishnakumar/Downloads/ChromeDriverLatest/ChromeDriver");

		driver = new ChromeDriver();
		driver.get("https://stage.baeroad.com/");
		driver.findElement(By.id("email")).sendKeys("ravimr");
		driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.xpath("//button[@type='button']//span[@class ='MuiButton-label']")).click();
		Thread.sleep(3000);

	}

	@Test(priority = 0)
	public void profile() throws InterruptedException {
	
	
	}

	@AfterMethod
	public void tearDown() {

		// driver.quit();

	}
	
	

}
