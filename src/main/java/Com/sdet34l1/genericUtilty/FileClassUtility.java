package Com.sdet34l1.genericUtilty;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consist only Property file specific common methods
 * @author PRAJWAL
 *
 */

public class FileClassUtility {
	
	static Properties property;
	/**
	 * This method is used to open the property file
	 * @throws IOException
	 */
	
	
	public static void openPropertyfile(String filepath) throws IOException {
		
		FileInputStream fis=new FileInputStream(filepath);
		property=new Properties();
		property.load(fis);
	}
	
	/**
	 * This method is fetch the data from the property file	
	 * @param Key
	 * @return
	 * @throws IOException 
	 */
	
	public static String getDataFromPropertyFile(String Key) throws IOException {
		
		String value = property.getProperty(Key);
		return value;
	}	
	}
	
	

