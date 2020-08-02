package bddrunners;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import apayloDataproviders.FileReaderManager;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
		features = {"src/test/resources/apayloFeatures"},
		glue = {"bddstepdefinitions","bddhooks"},
		plugin = {
		   "pretty",
	       "com.cucumber.listener.ExtentCucumberFormatter:target/apayloExtentReport.html",
	       "html:target/apaylo_html_Reports",
	       "json:target/apaylo-results.json", "pretty:target/apaylo-pretty-results.txt",
	       "usage:target/apaylo-usage-results.json", "junit:target/apaylo-results.xml", 
	       },
		dryRun = false,
		tags = {"@SIGNIN"},
		monochrome = true)

public class TestRunner{
	
	@AfterClass
	public static void writeExtentReport() {
		String line = null;
		BufferedReader bufferedReader = null;
		
//		Reporter.loadXMLConfig(new File(FileReaderManager.getConfigFileReader().getReportConfigPath()));
		Reporter.loadXMLConfig(new File(FileReaderManager.getConfigFileReader().getReportConfigPath()));
		//Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
		Reporter.setSystemInfo("Organisation Name", "Sp Software Pvt Ltd");
		Reporter.setSystemInfo("User Name", "Ramakrishna");
		Reporter.setSystemInfo("Application Name", "Apaylo Frontend Application (v1.0)");
		Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
		Reporter.setSystemInfo("Environment", "Testing");
		try {
			File logFile = new File("target/Logs/logfile.log");
			 bufferedReader = new BufferedReader(new FileReader(logFile));
			while ((line = bufferedReader.readLine()) != null) {
			Reporter.setTestRunnerOutput(line.toString()+"<br/>");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
