package Vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	@Test
	
	public void assertTest1() {
		
		System.out.println("hello");
		System.out.println("helloHi");
		System.out.println("hello123");
		Assert.assertTrue(false);
		System.out.println("hellojava");
		System.out.println("helloSelenium");
		System.out.println("helloPari");
	}
	@Test
    public void assertTest2() {
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(false);
		System.out.println("Step 3");
		System.out.println("Step 4");
		System.out.println("Step 5");
		sa.assertEquals(true, true);
		System.out.println("hello");
		sa.assertAll();
		Assert.assertEquals("A", "B");
		
		
		
	}   
		
		
		
	}

