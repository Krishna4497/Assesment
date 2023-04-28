package org.amazon.pom;

import org.amazon.drivers.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonLoginPage {
	
	WebDriver driver = null;
	
	public AmazonLoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	Actions act = new Actions(DriverSetup.driver);
	
	// Navigating to Sign in Page
	@FindBy(xpath = "//*[@id=\"nav-link-accountList-nav-line-1\"]")
	private WebElement signin_page;
	
	public void nav_signin_page()
	{
		signin_page.click();
	
	}
	
	// Entering User Name 
	@FindBy(id ="ap_email")
	private WebElement uname;
	
	public void user_name(String name)
	{
		uname.sendKeys(name);
	}
	
	// Navigating to Password Page
	@FindBy(id = "continue")
	private WebElement continue_btn;
	
	public void continuebtn()
	{
		continue_btn.click();
	}
	
	// Entering Password
	@FindBy(id = "ap_password")
	private WebElement pwd;
	
	public void password(String name)
	{
		pwd.sendKeys(name);
	}
	
	// Clicking on Sign In Button
	@FindBy(id = "signInSubmit")
	private WebElement signin_btn;
	
	public void signin()
	{
		signin_btn.click();
	}
	
	
}
