package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPOM  {

	
	
	@FindBy(linkText ="Arun.Kumar@gmail.com")
	public static WebElement profilelink;
	
	@FindBy(linkText ="Addresses")
	public static WebElement addresslink;
	
	
}
