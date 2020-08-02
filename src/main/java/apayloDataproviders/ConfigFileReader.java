package apayloDataproviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @name : ConfigFileReader
 * @author Ramakrishna
 * @description reads the config properties file and returns the specific value
 *
 */
public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath= System.getProperty("user.dir")+"/configs/configurations.properties";
	
	//*************************************************
	private static ConfigFileReader configFileReader;
	/**
	 * @name : getConfigFileReader
	 * @description loads the config file to return of the ConfiFileReader instance
	 * @return - ConfigFileReader
	 */
	public static ConfigFileReader getConfigFileReader() {		
		
		if (configFileReader != null) {
			 return configFileReader; 	
		}else {
			configFileReader = new ConfigFileReader();
			return configFileReader;
		}
	}
	//*************************************************
	
	
	/**
	 * @name : ConfigFileReader
	 * @description loads the config file to get the properties
	 */
	public ConfigFileReader(){
		System.out.println("Into Config file reader");
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	/**
	 * @name : getDriverPath
	 * @description get the location of the driver
	 * @return - String driverPath
	 */
	@SuppressWarnings("unused")
	public String getDriverPath() {
		String driverPath = System.getProperty("user.dir")+properties.getProperty("driverpath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
	
	/**
	 * @name : getImplicitlyWait
	 * @description get the specified time, from the property of implicitlywait
	 * @return - long
	 */
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlywait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
	}
	
	/**
	 * @name : getApplicationUrl
	 * @description get the application url, from the property of APP_URL
	 * @return - string
	 */
	public String getApplicationUrl() {
		String url=null;
		try {
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println(System.getenv("APP_URL"));
			url=System.getenv("APP_URL");
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		}
		catch(Exception e) {
			url = null;
		}
		if(url==null) {
			url = properties.getProperty("url");
		}
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	/**
	 * @name : getApplicationUrl
	 * @description get the Gateway url, from the property of apigateway
	 * @return - string
	 */
	public String getApiGatewayUrl() {
		String url = properties.getProperty("apigateway");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	/**
	 * @name : getKeyStatus
	 * @description get the Json key status, from the property of Jsonkeys
	 * @return - string
	 */
	public String getKeyStatus() {
		String url = properties.getProperty("Jsonkeys");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	/**
	 * @name : getWebDriverWait
	 * @description get the webdriver wait, from the property of webdriverwait
	 * @return - int
	 */
	public int getWebDriverWait() {
		String webdriverwait = properties.getProperty("webdriverwait");
		if(webdriverwait != null) return Integer.parseInt(webdriverwait);
		else throw new RuntimeException("webdriverwait not specified in the Configuration.properties file.");
	}
	
	/**
	 * @name : getPause
	 * @description get the pause time, from the property of pause
	 * @return - long
	 */
	public long getPause() {
		String pause = properties.getProperty("pause");
		if(pause != null) return Long.parseLong(pause);
		else throw new RuntimeException("pause not specified in the Configuration.properties file.");
	}
	
	
	/**
	 * @name : getPageLoadPause
	 * @description get the page load pause time, from the property of pageloadpause
	 * @return - long
	 */
	public long getPageLoadPause() {
		String pageloadpause = properties.getProperty("pageloadpause");
		if(pageloadpause != null) return Long.parseLong(pageloadpause);
		else throw new RuntimeException("pageloadpause not specified in the Configuration.properties file.");
	}
	
	/**
	 * @name : getElementsLoadTime
	 * @description get the elements load time, from the property of elementsloadtime
	 * @return - long
	 */
	public long getElementsLoadTime() {
		String elementsloadtime = properties.getProperty("elementsloadtime");
		if(elementsloadtime != null) return Long.parseLong(elementsloadtime);
		else throw new RuntimeException("elementsloadtime not specified in the Configuration.properties file.");
	}
	
	/**
	 * @name : getTemplatePath
	 * @description get the template path, from the property of templateloc
	 * @return - String
	 */
	/*public String getTemplatePath(){
        String templatePath = System.getProperty("user.dir")+properties.getProperty("templateloc");
        if(templatePath!= null) return templatePath;
        else throw new RuntimeException("templatePath not specified in the Configuration.properties file.");        
    }*/
	
	/**
	 * @name : getBrowser
	 * @description get the browser name, from the property of browser
	 * @return - String
	 */
	public String getBrowser() {
		String browserName = properties.getProperty("browser");
		if(browserName != null) return browserName;
		else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}
	
	/**
	 * @name : getBrowserWindowSize
	 * @description get the window Maximize, from the property of windowMaximize
	 * @return - Boolean
	 */
	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if(windowSize != null) return Boolean.valueOf(windowSize);
		return true;
	}
	
	/**
	 * @name : getReportConfigPath
	 * @description get the report config file Path, from the property of reportConfigPath
	 * @return - String
	 */
	public String getReportConfigPath(){
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
	
	/**
	 * @name : getObjectRepoPath
	 * @description get the Object repository file Path, from the property of ObjectRepoPath
	 * @return - String
	 */
	public String getObjectRepoPath(){
		String objectConfigPath = properties.getProperty("ObjectRepoPath");
		if(objectConfigPath!= null) return objectConfigPath;
		else throw new RuntimeException("Object Repo Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
	
	
	/**
	 * @name : getDocumentType
	 * @description get the template file type, from the property of template
	 * @return - String
	 */
	@SuppressWarnings("unused")
	public String getDocumentType(){
		String template = System.getProperty("user.dir")+properties.getProperty("template");
		if(template!= null) return template;
		else throw new RuntimeException("template is not specified in the Configuration.properties file.");		
	}
	
	/**
	 * @name : getRegularExpProperty
	 * @description get the regular expression property, from the property of property
	 * @return - String
	 */
	public String getRegularExpProperty(String property){
		String objectConfigPath = properties.getProperty(property);
		if(objectConfigPath!= null) return objectConfigPath;
		else throw new RuntimeException("Object Repo Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
 
}
