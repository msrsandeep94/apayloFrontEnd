package bddstepdefinitions;

import org.openqa.selenium.WebDriver;

import apayloDataproviders.EnvironmentFileReader;
import apayloPages.LoginPage;
import apayloPagesfactory.ApayloPageFactory;
import apaylodrivermanager.WebDriverManager;
import cucumber.api.java.en.Given;

public class Loginstepdefinition extends WebDriverManager {

	WebDriver driver = WebDriverManager.getDriver();
	ApayloPageFactory pagefactory = new ApayloPageFactory(driver);
	LoginPage loginPage = pagefactory.getLoginPage();

	@Given("^User is on Apaylo login page$")
	public void user_is_on_Ebook_Library_login_page() {
		driver.get(EnvironmentFileReader.getConfigFileReader().getqaURL());

	}

}
