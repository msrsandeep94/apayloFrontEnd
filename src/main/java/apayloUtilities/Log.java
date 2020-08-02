package apayloUtilities;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log {
	
	private static Logger Log = Logger.getLogger(Log.class.getName());
	
	private static boolean logInitialized = false;
	
	
	
	public static void initializeLog() {
		if (!logInitialized){
			DOMConfigurator.configure("src/main/java/config/log4j.xml");
			logInitialized = true;
		}		
		
	}
	
	
	public static void info(String message) {
		   Log.info(message);
		   }

	public static void warn(String message) {
	   Log.warn(message);
	   }

	public static void error(String message) {
	   Log.error(message);
	   }

	public static void fatal(String message) {
	   Log.fatal(message);
	   }

	public static void debug(String message) {
	   Log.debug(message);
	   }

}
