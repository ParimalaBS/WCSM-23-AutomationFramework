package Vtiger.Practice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;


public class RetryAnalyserPractice {
	
	@Test(retryAnalyzer = vTiger.GenericUtilities.RetryAnalyserImplementationClass.class)
	public void retryAnalyserTest1() {
		
		System.out.println("retryAnalyserTest1 Executed");
		Assert.fail();
		
	}
	
    @Test
	public void retryAnalyserTest2() {
		System.out.println("retryAnalyserTest2 Executed");
	}
}
