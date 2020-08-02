package apayloPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import apayloUtilities.ApayloSeleniumHelper;
import apayloUtilities.Log;

/**
 * @author Ramakrishna
 * @description Login Page Locators
 */
public class LoginPage extends ApayloSeleniumHelper {

	// WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	//*********Web Elements by using Page Factory*********

	@FindBy(xpath="//input[@placeholder='Email Address']")
	WebElement emailAddress;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath="//button[text()=' login ']")
	WebElement loginBtn;
	
	
	//*********Page Methods*********
	
	/**
	 * @description We will use this enterEbookDetails for enter the book details
	 */
	public void enterEmailAddress(String userName) {
		Log.info("Enters username as : " + userName + " on LoginPage");
		enterText(emailAddress, userName, "Enters username");
	}

	public void enterPassword(String pwd) {
		Log.info("Enters password as : " + pwd + " on LoginPage");
		enterText(password, pwd, "Enters Password :");
	}

	public void clickOnLoginButton() {
		Log.info("Clicking on Login Button on LoginPage");
		click(loginBtn, "Click on Login Button on LoginPage");
		waitForPageLoad();
	}

}
