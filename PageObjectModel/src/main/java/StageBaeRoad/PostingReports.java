package StageBaeRoad;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CommonActions.CommonAction;

public class PostingReports extends CommonAction {
	
	//WebDriver driver=null;
	
	@BeforeTest
	public void setData() {
		
		testName ="StageBaeRoad Post";
		testDesc ="Normal end to end post";
		testAuthor ="Krishna Kumar";
		testCategory ="Functional";
		
		
	}

	@BeforeMethod
	public void setup() throws Exception {

		System.setProperty("webdriver.chrome.driver", "/Users/krishnakumar/Downloads/ChromeDriverLatest/ChromeDriver");

		driver = new ChromeDriver();
		driver.get("https://stage.baeroad.com/");
		reportStep("url successfully launched","pass");
		driver.findElement(By.id("email")).sendKeys("ravimr");
		reportStep("email id successfully entered","pass");
		driver.findElement(By.id("password")).sendKeys("12345");
		reportStep("password successfully entered","pass");
		driver.findElement(By.xpath("//button[@type='button']//span[@class ='MuiButton-label']")).click();
		reportStep("button successfully clicked","pass");
		Thread.sleep(3000);

	}

	@Test(priority = 0)
	public void login() throws Exception {
		
	List<WebElement> li=	driver.findElements(By.xpath("//div[@class='infinite-scroll-component__outerdiv']/div/div/span"));
	System.out.println("Total post" +" "+li.size());
		
		driver.findElement(By.xpath("//img[@alt='create_post']")).click();
		reportStep("Click the post successfully","pass");
		driver.findElement(By.xpath("//div[@class ='modal_input']/textarea")).sendKeys("Hi How are you");
		reportStep("input keyed sucessfully","pass");

		driver.findElement(By.xpath("//div[contains(text(),'Free')]")).click();
		reportStep("click the choice of payment","pass");
		Thread.sleep(2000);
		List<WebElement> list=	 driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		System.out.println(list.size());
		
		driver.findElement(By.xpath("//ul[@role='listbox']/li[@data-value='paid']")).click();
		reportStep("click the payment option","pass");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='amount']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("100");
		reportStep("enter the dollar","pass");

		driver.findElement(By.xpath("//div[@class='post_submit_btn']/img")).click();
		reportStep("click the post successfully","pass");
	}


}
