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

public class ProfilePage {
	
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
		
	driver.findElement(By.xpath("//a[@class='jss17'][@href='/profile']")).click();
	Thread.sleep(2000);
		
	List<WebElement> posts =driver.findElements(By.xpath("//div[@class='profile_wrap']/div/span"));
	
	int posts_count =posts.size();
	
	System.out.println(posts.size());
	Thread.sleep(2000);
	String text =driver.findElement(By.xpath("//div[@class='post_details_wrap']/div/div/p[contains(text(),'POSTS')]/preceding-sibling::h3")).getText();
	
	int post_count =Integer.parseInt(text);
	
	System.out.println(post_count);
	
	
	Assert.assertEquals(posts_count, post_count,"Both count is not matched");
		
		
	
	}

	@AfterMethod
	public void tearDown() {

		// driver.quit();

	}
	
	
	
	

}
