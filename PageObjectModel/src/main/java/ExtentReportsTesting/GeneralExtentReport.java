package ExtentReportsTesting;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class GeneralExtentReport {
	
	public static void main(String[] args) throws IOException {
		
	/*	
		// To create a html report
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("/Users/krishnakumar/Downloads/ChromeDriverLatest/result.html");
		
		//to maintain execution history
		
		reporter.setAppendExisting(true);
		
		//To Design a report
		
		ExtentReports extent = new ExtentReports();
		
		// To Attach the design with physical html report
		
		extent.attachReporter(reporter);
		
		
		//testcase level info
		ExtentTest test = extent.createTest("LoginLogout","Postive testcase for loginfunctionality");
		
		test.assignAuthor("krishna");
		test.assignCategory("Functional");
		
		//Step level info
	
		test.pass("test", MediaEntityBuilder.createScreenCaptureFromPath("/Users/krishnakumar/Downloads/ChromeDriverLatest/om.jpeg").build());
		test.pass("password is entered succesfully", MediaEntityBuilder.createScreenCaptureFromPath("/Users/krishnakumar/Downloads/ChromeDriverLatest/om.jpeg").build());
		test.fail("login button is not clicked properl");
		
		//flush
		extent.flush();
	*/	
	}
	

}
