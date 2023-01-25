package Vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFie {

	public static void main(String[] args) throws IOException {
		
		// Step :1  Read the file in java readable format using file input stream
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\CommonData.Properties");
		
		//Step :2  create the object of properties calss from java util
		Properties pObj= new Properties();
		
		//Step:3   load the input 
		pObj.load(fis);
		
		// Step :4  provide the key and read the value
		
		String Browser = pObj.getProperty("browser");
		System.out.println(Browser);
		String URL = pObj.getProperty("url");
		System.out.println(URL);
		String UN = pObj.getProperty("username");
		System.out.println(UN);
		String pwd = pObj.getProperty("password");
		System.out.println(pwd);
		
	}

}
