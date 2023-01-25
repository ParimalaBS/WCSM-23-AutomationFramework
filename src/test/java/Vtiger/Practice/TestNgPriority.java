package Vtiger.Practice;

import org.testng.annotations.Test;

public class TestNgPriority {
	
	@Test
	public void  gattimelaTest() {
		
		System.out.println("Amulya");
		int a= 10/0;
	}
	@Test(priority=5)
	public void kannadathiTest() {
		
		System.out.println("Bhuvi");
	}
	@Test(enabled = false)
	public void puuttakkanaMakkaluTest() {
		
		System.out.println("Sneha");
		
	}
	@Test(dependsOnMethods ={"gattimelaTest","sathyaTest"})
	public void hitlerkalyanaTest() {
		System.out.println("Leela");
	}
	@Test(priority=1)
	public void sathyaTest() {
		System.out.println("Sathya");
	}
}
