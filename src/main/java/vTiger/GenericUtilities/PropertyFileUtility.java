package vTiger.GenericUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * this class consists of generic methods related to  property file
 * @author vijay
 *
 */

public class PropertyFileUtility {
	/**
	 * This method will return read from property file and return the value of key 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	
	public String readDataFromPropertyFile(String key) throws IOException {
		
		 FileInputStream fis = new FileInputStream(IConstantUtility.PropertyFilePath);
		 Properties pObj= new Properties();
		 pObj.load(fis);
	     String value = pObj.getProperty(key);
		 return value;
		
	}

}
