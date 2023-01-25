package Vtiger.Organization.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.BaseClass;
import vTiger.GenericUtilities.ExcelUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInformationPage;
import vTiger.ObjectRepository.OrganizationPage;
@Listeners(vTiger.GenericUtilities.ListenersImplementationClass.class)
public class CreateOrganizationWithIndustryDataProvider extends BaseClass {
	
	@Test(dataProvider = "getOrgData")
	public void createOrganizationTest(String OrgName, String IndustryName) throws IOException {
		
		String ORGName = OrgName + jUtil.getRandomNumber();
	
				//Step 1 : Click on OrganizationLink
				
				HomePage hp=new HomePage(driver);
				hp.clickOnOrganizationLink();
				
				//Step 2 : Click on Organization Lookup icon
				
				 OrganizationPage op=new  OrganizationPage(driver);
				 op.clickOnOrglookUpIcon();
				
				//Step 3 : Create new Organization with Mandatory fields and Industry and save 
				 
				CreateNewOrganizationPage CnO=new CreateNewOrganizationPage(driver);
				CnO.CreatNewOrganization(ORGName, IndustryName);
				
				//Step 4: validate 
				
				OrganizationInformationPage oi=new OrganizationInformationPage(driver);
				String OrgHeader = oi.getOrganizationHeader();
				Assert.assertTrue(OrgHeader.contains(ORGName));
				
			 
		 }
	
	     @DataProvider()
	    public Object[][] getOrgData() throws EncryptedDocumentException, IOException {
	    	 
	    	Object[][] data =eUtil.readMultipledata("Sheet1");
	    	
	    	return data;
	    	 
	     
	    	
	    	
	    }

}
