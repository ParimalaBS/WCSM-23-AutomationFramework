package vTiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class RetryAnalyserImplementationClass implements IRetryAnalyzer{
	
	int count=0;
	int retry=2;
	/**
	 * This method will re-run Until the count met
	 */
	public boolean retry(ITestResult result) {
		
		
		while(count<retry) {
			
			count++;
			return true;
		}
		
	       return false;
	}
	
	
	
	
	

}
