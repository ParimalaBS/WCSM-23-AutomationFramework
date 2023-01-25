package Vtiger.Contact.TestScripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;

@Listeners(vTiger.GenericUtilities.ListenersImplementationClass.class)
public class DemoListenerTest extends  BaseClass  {
	
	
	@Test
	public void DemoTest() throws InterruptedException {
		System.out.println("Demo Test ");
		Thread.sleep(5000);
	}
	
	@Test
	public void SampleTest() throws InterruptedException {
		System.out.println("Sample Test ");
		Thread.sleep(5000);
		//Assert.fail();
	} 


}
