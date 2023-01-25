package Vtiger.Organization.TestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.BaseClass;
import vTiger.GenericUtilities.ExcelUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
@Listeners(vTiger.GenericUtilities.ListenersImplementationClass.class)
public class CreateOrganizationWithDDtAndGUTest extends BaseClass
{
	@Test
	public void  CreateOrganizationWithDDtAndGUTest() throws IOException
	{
		
		//Step 1: Read all the Required data
		
		String ORGName = eUtil.readDataFromExcelSheet("Organization", 1, 2) + jUtil.getRandomNumber();;
		
		 
		//Step 2: Click on Organization link
		 
		 driver.findElement(By.linkText("Organizations")).click();
		
		//Step 3: click on create Organization lookup image
		 driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		
		 //Step 4 : Create Organization with mandatory fields
		 
		driver.findElement(By.name("accountname")).sendKeys(ORGName) ;
		 //Step 5: Save
		 driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		 //Step 8: Verify
		 String OrganizationHeader = driver.findElement(By.className("dvHeaderText")).getText();
			Assert.assertTrue(OrganizationHeader.contains(ORGName));
			System.out.println(OrganizationHeader);
			}

}
