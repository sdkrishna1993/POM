package CommonActions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class CommonAction {

	public static Properties properties = null;
	public static WebDriver driver = null;
	public static ExtentHtmlReporter reporter = null;
	public static ExtentReports extent = null;
	public static ExtentTest test = null;
	public String testName, testDesc, testAuthor, testCategory;

	/*
	 * public static Properties loadpropertyfile() throws IOException {
	 * 
	 * FileInputStream stream = new FileInputStream("Config.properties"); properties
	 * = new Properties(); properties.load(stream);
	 * 
	 * 
	 * // System.out.println("loading"); return properties;
	 * 
	 * }
	 */

	@BeforeSuite
	public static void extentReports() throws IOException {

		FileInputStream stream = new FileInputStream("Config.properties");
		properties = new Properties();
		properties.load(stream);

		// To create a html report

		reporter = new ExtentHtmlReporter("/Users/krishnakumar/Downloads/ChromeDriverLatest/"+properties.getProperty("reportname")+".html");

		// to maintain execution history

		// reporter.setAppendExisting(true);

		// To Design a report

		extent = new ExtentReports();

		// To Attach the design with physical html report

		extent.attachReporter(reporter);
	}

	@BeforeClass
	public void testDetails() throws IOException {

		// testcase level info
		test = extent.createTest(testName, testDesc);

		test.assignAuthor(testAuthor);
		test.assignCategory(testCategory);

		// Step level info

		// test.pass("test",
		// MediaEntityBuilder.createScreenCaptureFromPath("/Users/krishnakumar/Downloads/ChromeDriverLatest/om.jpeg").build());
		// test.pass("password is entered succesfully",
		// MediaEntityBuilder.createScreenCaptureFromPath("/Users/krishnakumar/Downloads/ChromeDriverLatest/om.jpeg").build());
		// test.fail("login button is not clicked properl");

		// flush

	}

	public long takeSnapShot() throws Exception {

		long number = (long) Math.floor((Math.random() * 90000000000L) + 1000000000L);

		// Convert web driver object to TakeScreenshot

		// TakesScreenshot scrShot =((TakesScreenshot)webdriver);

		// Call getScreenshotAs method to create image file

		File Src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File("/Users/krishnakumar/Downloads/ChromeDriverLatest/img" + number + ".png");

		// Copy file at destination

		FileUtils.copyFile(Src, DestFile);

		return number;

	}

	public void reportStep(String msg, String status) throws Exception {

		if (status.equals("pass")) {

			test.pass(msg,
					MediaEntityBuilder
							.createScreenCaptureFromPath(
									"/Users/krishnakumar/Downloads/ChromeDriverLatest/img" + takeSnapShot() + ".png")
							.build());
		} else {

			test.fail(msg,
					MediaEntityBuilder
							.createScreenCaptureFromPath(
									"/Users/krishnakumar/Downloads/ChromeDriverLatest/img" + takeSnapShot() + ".png")
							.build());
		}

	}

	@BeforeMethod
	public void setup1() throws IOException {

		String browser = properties.getProperty("browser");
		String un = properties.getProperty("username");
		String pass = properties.getProperty("password");
		String url = properties.getProperty("url");
		String drivelocation = properties.getProperty("driverLocation");
		System.out.println(browser);
		System.out.println(un);
		System.out.println(pass);
		System.out.println(url);
		System.out.println(drivelocation);

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", drivelocation);
			driver = new ChromeDriver();

		}

		else if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("gechodriver.firfox.driver", drivelocation);
			driver = new FirefoxDriver();

		}

		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void tearDown() {

		// driver.quit();

	}

	@AfterSuite
	public void flus() {

		extent.flush();
	}

}
