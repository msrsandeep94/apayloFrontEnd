package bddhooks;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import apayloUtilities.Log;
import apayloUtilities.ApayloSeleniumHelper;
import apaylodrivermanager.WebDriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class hooks {

	@Before
	public void Before(Scenario scenario) {
//		String strScenario = scenario.getName();
		ApayloSeleniumHelper.setScenario(scenario);
		Log.initializeLog();
		Log.info("**********************************************");
		Log.info(" Started Working on Scenario : "+scenario.getName());
		Log.info("**********************************************");
//		WebDriverManager.initDriver();
	}

	@After
	public void After(Scenario scenario) {
//		String strScenario = scenario.getName();
		ApayloSeleniumHelper.setScenario(scenario);
		if (scenario.isFailed()) {
			WebDriver driver =WebDriverManager.getDriver();
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png"); //stick it in the report
		}
		/*Log.info("############## Ending Scenario " +strScenario + "##############");*/
		Log.info("**********************************************");
		Log.info(" Completed Working on Scenario : "+ scenario.getName());
		Log.info("**********************************************");
		//Reporter.addStepLog("Into Hooks - Closing the driver");		
		WebDriverManager.closeDriver();

	}

}
