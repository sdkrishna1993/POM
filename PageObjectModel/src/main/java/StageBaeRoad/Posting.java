package StageBaeRoad;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Posting {

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
	public void login() throws InterruptedException {
		
	List<WebElement> li=	driver.findElements(By.xpath("//div[@class='infinite-scroll-component__outerdiv']/div/div/span"));
	System.out.println("Total post" +" "+li.size());
		
		driver.findElement(By.xpath("//img[@alt='create_post']")).click();
		driver.findElement(By.xpath("//div[@class ='modal_input']/textarea")).sendKeys("Hi How are you");

		driver.findElement(By.xpath("//div[contains(text(),'Free')]")).click();
		Thread.sleep(2000);
		List<WebElement> list=	 driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		System.out.println(list.size());
		
		driver.findElement(By.xpath("//ul[@role='listbox']/li[@data-value='paid']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='amount']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("100");

		driver.findElement(By.xpath("//div[@class='post_submit_btn']/img")).click();
	}

	@AfterMethod
	public void tearDown() {

		// driver.quit();

	}
}
