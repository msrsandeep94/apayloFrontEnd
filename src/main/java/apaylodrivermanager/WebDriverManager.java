package apaylodrivermanager;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import apayloDataproviders.ConfigFileReader;
import apayloUtilities.Log;

/**
 * @name : WebDriverManager
 * @author Ramakrishna
 * @description webdriver initialization and managing the properties of the webdriver
 *
 */
public class WebDriverManager {
	
	private  static WebDriver driver = null;
	private static String driverType;
	
	private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();
	
	
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	
	static ConfigFileReader cfr;
	 
	
	public WebDriverManager() {			
		
	}
	
	/**
	 * @name : getDriver
	 * @description initializing the driver and returns the webdriver instance
	 * @return - WebDriver
	 */
	 @SuppressWarnings("deprecation")
	public static WebDriver getDriver() {
		//cfr = FileReaderManager.getConfigFileReader();
		driverType = ConfigFileReader.getConfigFileReader().getBrowser();	
		Log.info("Initializing Driver :"+driverType);
        switch (driverType) {        
        
        case "chrome" :
            driver = drivers.get("Chrome");
            System.out.println("The getdriver instance is :"+driver);
            
            if (driver==null || driver.toString().contains("(null)")) {
                 System.setProperty(CHROME_DRIVER_PROPERTY, ConfigFileReader.getConfigFileReader().getDriverPath());
                 ChromeOptions options = new ChromeOptions();
                 //options.addArguments("--headless");
                 //options.addArguments("--disable-gpu");
                 options.addArguments("--incognito");
                 
    /*------------------------------------------------------------------------*/      
                 HashMap<String, Object> prefs = new HashMap<String, Object>();    
                 // Use File.separator as it will work on any OS
                 prefs.put("download.default_directory",
                                 System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles");            
                 options.setExperimentalOption("prefs", prefs);    
                 // Printing set download directory
                 System.out.println(options.getExperimentalOption("prefs"));            
    /*------------------------------------------------------------------------*/ 
                 
                 DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                 capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                 driver= new ChromeDriver(capabilities);
                 drivers.put("Chrome", driver);
                
               /* System.setProperty(CHROME_DRIVER_PROPERTY, ConfigFileReader.getConfigFileReader().getDriverPath());
                ChromeOptions options = new ChromeOptions();
                //options.addArguments("--incognito");
                options.addArguments("--headless");
                //*****************************************************8
                //options.setBinary("/opt/google/chrome/");
                options.setBinary("/opt/google/chrome/chrome");
                //options.setBinary("/usr/bin/google-chrome");
                options.addArguments("--no-sandbox");
                //*****************************************************8
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                driver= new ChromeDriver(capabilities);
                drivers.put("Chrome", driver);
                Log.info("Created driver is :"+driver.toString());*/
                try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            }
            /*System.setProperty(CHROME_DRIVER_PROPERTY, ConfigFileReader.getConfigFileReader().getDriverPath());
            driver = new ChromeDriver();
            drivers.put("Chrome", driver);*/
    		break;
        }

        /*if(cfr.getBrowserWindowSize()) {
        	driver.manage().window().maximize();
        }
        
        driver.manage().timeouts().implicitlyWait(cfr.getImplicitlyWait(), TimeUnit.SECONDS);
        System.out.println("The driver Type is2 :"+driverType);*/
		return driver;
	}	
	
	 /**
	 * @name : closeDriver
	 * @description close or quit the webdriver
	 * @return - void
	 */
	public static void closeDriver() {
		try {
			driver.quit();
//			driver.close();
		}catch(Exception e) {
			Log.error("Either Driver is not initialized or closed before");
		}
		
		
	}
	
	

}
