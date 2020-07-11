package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import CommonActions.CommonAction;

public class LoginPOM extends CommonAction{
	
	
	
	@FindBy(how =How.ID,using ="Email")
	 public static WebElement username;
	
	
	
	@FindBy (id ="Password")
	public static WebElement password;
	
	
		
		
	@FindBy(xpath ="//input[@type='submit'][@value='Log in']")
	public static WebElement loginButton;
	
	
	
	
	
	
}
