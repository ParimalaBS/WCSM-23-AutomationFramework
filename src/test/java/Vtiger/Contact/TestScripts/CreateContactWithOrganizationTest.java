package Vtiger.Contact.TestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.ExcelUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
@Listeners(vTiger.GenericUtilities.ListenersImplementationClass.class)
public class CreateContactWithOrganizationTest extends WebDriverUtility {

	@Test
	public void CreateContactWithOrganizationTest() throws IOException {
		
		//Step 1: Create Object for all Required Libraries 
		
		WebDriverUtility wUtil = new WebDriverUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelUtility eUtil= new ExcelUtility();
		JavaUtility jUtil=new JavaUtility();
		
		//Step 2: Read all the Required data 
		
		String Browser = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String pwd=pUtil.readDataFromPropertyFile("password");
		String Lastname = eUtil.readDataFromExcelSheet("Contact", 4, 2);
		String OrgName=eUtil.readDataFromExcelSheet("Contact", 4, 3);
		
		//Step 3: Launch the Browser
		
		WebDriver driver=null;	
		
		if (Browser.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			 driver= new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup(); 
			 driver= new ChromeDriver();
		}
		else {
			System.out.println("Invalid browser name");
		}
		
		 wUtil.maximizeWindow(driver);
		 wUtil.waitForpageLoad(driver);
		 driver.get(URL);
		
		// Step 4: Login to the Application 
		 
		 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 driver.findElement(By.name("user_password")).sendKeys(pwd);
		 driver.findElement(By.id("submitButton")).click();
		 
		 // Step 5: click on Organization link
		 	driver.findElement(By.linkText("Organizations")).click();
			
			//Step 6 : click on create Organization lookup image
			 driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
				
			 // Step 7: Create Organization with Mandatory fields and Save
			 
			 driver.findElement(By.name("accountname")).sendKeys(OrgName) ;
			 driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
			 
			 //Step 8: verify
			 
			  String OrganizationHeader = driver.findElement(By.className("dvHeaderText")).getText();
				if(OrganizationHeader.contains(OrgName)) {
					System.out.println(OrganizationHeader);
					System.out.println("PASS");
					System.out.println("OrganizationHeader");
				}else {
					System.out.println("Organization is not created");
				}
				
			// Step 9: click on Contacts link 
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();
			
		   //Step 10: click on create contact lookup icon
		    driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
					 
			 //Step 11: Create Contact with Mandatory Fields
					 
			 driver.findElement(By.name("lastname")).sendKeys(Lastname);
					 
		    //Step 12: Choose Organization
			 driver.findElement(By.xpath("//input[@name='account_name']/..//img[@alt='Select']")).click();
			 wUtil.switchToWindow(driver, "Accounts");
			 driver.findElement(By.id("search_txt")).sendKeys(OrgName);
			 driver.findElement(By.name("search")).click();
			 driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
			 wUtil .switchToWindow(driver, "Contacts");
			 
		  //Save 
			 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			 
		 //Step 13: verify - contact is created or not 
			 String HeaderText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			 if (HeaderText.contains(Lastname)) {
				 System.out.println(HeaderText);
				 System.out.println("pass");
			}else{
				System.out.println("fail");
				
			}
			//Step 14 : Logout from the Application
				WebElement menuOption = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wUtil.mouseHovering(driver, menuOption);
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				driver.quit();
			 
	}

}
