package ExtentReportsTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportSample {
	
	WebDriver driver;
	ExtentReports extentReport;
	ExtentHtmlReporter htmlreporter;
	ExtentTest testcase;
	
	@BeforeSuite
    public void setup() {
	    System.setProperty("webdriver.chrome.driver", "/Users/krishnakumar/Downloads/ChromeDriverLatest/ChromeDriver");

		driver = new ChromeDriver();
		extentReport = new ExtentReports();
		htmlreporter = new ExtentHtmlReporter("/Users/krishnakumar/Downloads/ChromeDriverLatest/ExtentReport.html");
		extentReport.attachReporter(htmlreporter);
		
  }

	@Test(priority =1)
	public void VerifyGoogleTitle() {
		
		
		testcase =extentReport.createTest("Verify google title");
		driver.get("https://www.google.com");
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		if (actualTitle.equals("Google")) {

			System.out.println("The actual and expected title is same");
		}

		else {

			System.out.println("The actual ane expected titile is not matched");
		}

	}

	@Test(priority =2)
	public void verifyDemoTestTitle() {
		testcase =extentReport.createTest("Verify Demo title");
		driver.get("http://demowebshop.tricentis.com/");
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		if (actualTitle.equals("Google")) {

			System.out.println("The actual and expected title is same");
		}

		else {

			System.out.println("The actual ane expected titile is not matched");
		}

	}

	@Test(priority =3)
	public void verifyYahooTitle() {
		testcase =extentReport.createTest("Verify Yahoo  title");
		driver.get("https://in.yahoo.com/?p=us");
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);

		if (actualTitle.equals("Google")) {

			System.out.println("The actual and expected title is same");
		}

		else {

			System.out.println("The actual ane expected titile is not matched");
		}

	}

	@AfterSuite
	public void tearDown() {

		driver.quit();
		extentReport.flush();
		

	}
	
	
	

}
