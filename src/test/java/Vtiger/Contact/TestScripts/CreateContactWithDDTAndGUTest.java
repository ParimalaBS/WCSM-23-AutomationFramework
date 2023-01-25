package Vtiger.Contact.TestScripts;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.HomePage;
@Listeners(vTiger.GenericUtilities.ListenersImplementationClass.class)

public class CreateContactWithDDTAndGUTest extends BaseClass{
	@Test

	public void  CreateContactWithDDTAndGUTest() throws IOException {
		
	
		String Lastname = eUtil.readDataFromExcelSheet("Contact", 4, 2);
		String LeadSource = eUtil.readDataFromExcelSheet("Contact", 4, 3);
		
	
		 // Step 1: Click on Contact link
		 HomePage hp=new HomePage(driver);
		 hp.clickOnContactslink();
		
		//Step 2 : click on create contact lookup icon
		 ContactsPage cp=new ContactsPage(driver);
		 cp.clickOnContactImg();
		 
		 //Step 3 : Create Contact with Mandatory Fields and save
		 CreateNewContactPage cnp=new CreateNewContactPage(driver);
		 cnp.createNewContactWithOrg(Lastname); 
		 
			
		//Step 4 :validate - contact created or not
		 String ContactHeaderText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 Assert.assertTrue(ContactHeaderText.contains(Lastname));
}
        
}
