package StageBaeRoad;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CommonActions.CommonAction;

public class PaymentSum extends CommonAction{
	
	@BeforeTest
	public void setData() {
		
		testName ="StageBaeRoad PaymentSum";
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
		Thread.sleep(5000);

	}

	@Test(priority = 0)
	public void login() throws Exception {
		
		driver.findElement(By.xpath("//img[@class='nav-avatar'][@alt='avatar']")).click();
		driver.findElement(By.xpath("//a[@class='settings_link']/li")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='types_wrap']/a[@href='/settings/payment']/div/img")).click();
		Thread.sleep(3000);
		
	List<WebElement> tableCount=	driver.findElements(By.xpath("//div[@class='pay_table']/div/table/tr"));
	
	System.out.println(tableCount.size());
	
	int TotalCount =tableCount.size();
	
	double fullAmount =0;
	for (int i = 2; i <= TotalCount; i++) {
		
	String Amount =	driver.findElement(By.xpath("//div[@class='table-responsive']/table/tr["+i+"]/td[4]")).getText();
	System.out.println(Amount);
	
	String ConvertAmount =Amount.substring(1);
	
	double amount =Double.parseDouble(ConvertAmount);
	
	 fullAmount =fullAmount +amount;
	
		
	}

	System.out.println(fullAmount);
	
		
	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	String a ="//img[@class='nav-avatar'][@alt='avatar']";
	String settingLink ="//a[@class='settings_link']/li";
	String clickPayment ="//div[@class='types_wrap']/a[@href='/settings/payment']/div/img";
	
	
	String tablecount ="//div[@class='table-responsive']/table/tr";
	String table ="//div[@class='table-responsive']/table/tr[2]/td[4]";
	*/
	

}
