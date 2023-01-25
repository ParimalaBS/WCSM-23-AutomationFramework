package Vtiger.Organization.TestScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.google.j2objc.annotations.Property;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.BaseClass;
@Listeners(vTiger.GenericUtilities.ListenersImplementationClass.class)
public class CreateOrganizationWithDDTTest extends BaseClass {
	
	@Test
	public void  CreateOrganizationWithDDTTest() throws IOException{
		Random rd=new Random();
		int randNum = rd.nextInt();
		
		/* Read the data from excel sheet*/
		FileInputStream fisE =new FileInputStream(".\\src\\test\\resources\\VtigerTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fisE);
		String OrgName = wb.getSheet("Organization") .getRow(1) .getCell(2).getStringCellValue()+randNum;
		
		 
		//Step 4: Click on Organization link
		 
		 driver.findElement(By.linkText("Organizations")).click();
		
		//Step 5: click on create Organization lookup image
		 driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		
		//Step 6: Create Organization with mandatory  fields
		 driver.findElement(By.name("accountname")).sendKeys(OrgName);
		 
		 //Step 7: save
		 driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
			
		//Step 8: Verify Organization is created or not 
		String OrganizationHeader = driver.findElement(By.className("dvHeaderText")).getText();
			Assert.assertTrue(OrganizationHeader.contains(OrgName));
	}
	
            @Test (groups = "SmokeSuite")  
			public void test1() {
				System.out.println("hi");
				}
            
            @Test  
			public void test2() {
				System.out.println("Bye");
				}
            
            @Test  (groups = "Regressionsuite") 
			public void test3() {
				System.out.println("Hello");
				}

	}

