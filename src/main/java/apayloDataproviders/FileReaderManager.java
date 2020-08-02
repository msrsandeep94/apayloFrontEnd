package apayloDataproviders;

/**
 * @name : FileReaderManager
 * @author Ramakrishna
 * @description we will be having many more file readers,
 *  So it is better to have a File Reader Manager it’s appropriate to have exactly one instance of a class 
 * 
 */
public class FileReaderManager {
	
	private static ConfigFileReader configFileReader;
	private static EnvironmentFileReader environmentFileReader;
	
	private FileReaderManager() {			
		
	}
	
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
	
	/**
	 * @name : getEnvironmentFileReader
	 * @description loads the environment file to return of the EnvironmentFileReader instance
	 * @return - ConfigFileReader
	 */	
	public static EnvironmentFileReader getEnvironmentFileReader() {		
		
		if (environmentFileReader != null) {
			 return environmentFileReader; 	
		}else {
			environmentFileReader = new EnvironmentFileReader();
			return environmentFileReader;
		}
	}
	
	

}
