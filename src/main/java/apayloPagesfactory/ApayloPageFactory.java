package apayloPagesfactory;

import org.openqa.selenium.WebDriver;

import apayloPages.LoginPage;
import apayloUtilities.Log;


/**
 * @author Ramakrishna
 * @description We use StafPageFactory for Page Factory pattern to initialize web elements which are defined in Page Objects
 */

public class ApayloPageFactory {

	private LoginPage loginpage;
	// private AddEBookPage addEBookPage;
	

	private WebDriver driver;
	
	/*** 
	* Constructor 
	* @param driver an instance of WebDriver 
	*/
	public ApayloPageFactory(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @description Create object of LoginPage Class
	 * @return Instantiate the LoginPage Class
	 */
	public LoginPage getLoginPage(){
		Log.info("Initializing LoginPage");
		System.out.println(loginpage);
		return (loginpage == null) ? loginpage = new LoginPage(driver) : loginpage;
	}

	/**
	 * @description Create object of AddEBookPage Class
	 * @return Instantiate the AddEBookPage Class
	 *//*
	public AddEBookPage getAddEBookPage() {
		Log.info("Initializing UserRoles Page");
		return (addEBookPage == null) ? addEBookPage = new AddEBookPage(driver) : addEBookPage;
	}
*/

	
	
}
