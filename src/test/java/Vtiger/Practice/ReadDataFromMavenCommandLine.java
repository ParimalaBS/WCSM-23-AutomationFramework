package Vtiger.Practice;

import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;

public class ReadDataFromMavenCommandLine  extends BaseClass{

	
	
	@Test
	public void ReadData() {
		
		String Browser = System.getProperty("browser");
		System.out.println(Browser);
		
		String URL=System.getProperty("url");
		System.out.println(URL);
		
		String USERNAME=System.getProperty("username");
		System.out.println(USERNAME);
		
		String PASSWORD=System.getProperty("password");
		System.out.println(PASSWORD);
		
	}
}
