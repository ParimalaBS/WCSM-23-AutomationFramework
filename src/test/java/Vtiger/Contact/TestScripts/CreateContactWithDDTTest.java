package Vtiger.Contact.TestScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.BaseClass;
@Listeners(vTiger.GenericUtilities.ListenersImplementationClass.class)
public class CreateContactWithDDTTest extends BaseClass {
@Test
	public void CreateContactWithDDTTest() throws EncryptedDocumentException, IOException, InterruptedException {
		//Step 1: Read all the data from  external Resources
		/* Read the data from property file*/
		
		 FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.Properties");
		 Properties pObj=new Properties();
		 pObj.load(fis);
		 String BROWSER = pObj.getProperty("browser");
		 String USERNAME = pObj.getProperty("username");
		 String pwd=pObj.getProperty("password");
		 
		// read data from excel sheet
		 
		 FileInputStream fisE=new FileInputStream(".\\src\\test\\resources\\VtigerTestData.xlsx");
		 Workbook wb = WorkbookFactory.create(fisE);
		 String LastName = wb.getSheet("Contact").getRow(1).getCell(2).getStringCellValue();
		 String LeadSource = wb.getSheet("Contact").getRow(4).getCell(3).getStringCellValue();
		 
	
		 
		// Step :3 Login to the aplication 
		 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 driver.findElement(By.name("user_password")).sendKeys(pwd);
		 driver.findElement(By.id("submitButton")).click();
		 
	    // Step 4: Click on Contact link
		 driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//Step 5: click on create contact lookup icon
		 driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			
		//Step 6: create contact with mandatory fields
		 driver.findElement(By.name("lastname")).sendKeys(LastName);
		 Select leaddrpdwn=new Select(driver.findElement(By.name("leadsource")));
		 leaddrpdwn.selectByValue(LeadSource);
		 
		//Step 7: save
		 driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		//Step 8: validate - contact created or not
		 String HeaderText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 Assert.assertTrue(HeaderText.contains(LastName));
			}

}
