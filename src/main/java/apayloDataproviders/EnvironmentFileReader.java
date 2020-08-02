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
public class EnvironmentFileReader {
	private Properties properties;
	private final String propertyFilePath= System.getProperty("user.dir")+"/configs/e.properties";
	
	//*************************************************
	private static EnvironmentFileReader configFileReader;
	/**
	 * @name : getConfigFileReader
	 * @description loads the config file to return of the ConfiFileReader instance
	 * @return - ConfigFileReader
	 */
	public static EnvironmentFileReader getConfigFileReader() {		
		
		if (configFileReader != null) {
			 return configFileReader; 	
		}else {
			configFileReader = new EnvironmentFileReader();
			return configFileReader;
		}
	}
	//*************************************************
	
	
	/**
	 * @name : ConfigFileReader
	 * @description loads the config file to get the properties
	 */
	public EnvironmentFileReader(){
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
	public String getqaURL() {
		String driverPath = System.getProperty("user.dir")+properties.getProperty("qaURL");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("qa url in the environment.properties file.");		
	}
	/**
	 * @name : getReportConfigPath
	 * @description get the report config file Path, from the property of reportConfigPath
	 * @return - String
	 */
	public String getuserOneUserName(){
		String userOneUserName = properties.getProperty("userOneUserName");
		if(userOneUserName!= null) return userOneUserName;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
	
	
}

