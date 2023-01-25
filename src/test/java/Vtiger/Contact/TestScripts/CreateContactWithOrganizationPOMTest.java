package Vtiger.Contact.TestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.BaseClass;
import vTiger.GenericUtilities.ExcelUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.ContactInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInformationPage;
import vTiger.ObjectRepository.OrganizationPage;
@Listeners(vTiger.GenericUtilities.ListenersImplementationClass.class)
public class CreateContactWithOrganizationPOMTest extends BaseClass {

	@Test
	public void CreateContactWithOrganizationTest() throws IOException {
		 
		String Lastname = eUtil.readDataFromExcelSheet("Contact", 7, 2);
		String OrgName= eUtil.readDataFromExcelSheet("Contact", 7, 3)+ jUtil.getRandomNumber();
		
		//	 Step : 1 Click on  Organization link
		  HomePage hp=new HomePage(driver);
		  hp.clickOnOrganizationLink();
			
		//Step 2 : click on create Organization lookup image
		  OrganizationPage op=new OrganizationPage(driver);
		  op.clickOnOrglookUpIcon();
		
			
		 // Step 3 : Create Organization with Mandatory fields and Save
		 
		CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		cop.CreateNewOrganization(OrgName);
		
		 //Step 4: verify
		  OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		 String OrgHeaderText = oip.getOrganizationHeader();
		  Assert.assertTrue(OrgHeaderText.contains(OrgName));
			
		   //Step 5: Navigate to Contact link
			hp.clickOnContactslink();
			
			
		 //Step 6 : click on create contact lookup icon
			 ContactsPage cp=new ContactsPage(driver);
			 cp.clickOnContactImg();
			 
			 
		 //Step 7 : Create Contact with Mandatory Fields with organization and save 
			 CreateNewContactPage cnp=new CreateNewContactPage(driver);
			 cnp.createNewContactWithOrg(driver, Lastname, OrgName);
			 
		 //Step 8:   validate - contact created or not
			 
			 ContactInfoPage cip=new ContactInfoPage();
			String ContactHeader = cip.getContactheaderText();
			Assert.assertTrue(ContactHeader.contains(Lastname));
			System.out.println(ContactHeader);
	
			
			//Step 9 : Logout from the Application
				hp.LogoutFromApp(driver);
	}
}
				




