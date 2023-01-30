package Vtiger.Organization.TestScripts;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
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

public class CreateOrganizationWithIndustryPOMTest extends BaseClass{
	
    @Test(retryAnalyzer = vTiger.GenericUtilities.RetryAnalyserImplementationClass.class)
	public void CreateOrganizationWithIndustryPOMTest() throws IOException {   
		
		//Step 1: Read the Required data 
		String ORGName = eUtil.readDataFromExcelSheet("Organization", 4, 2) + jUtil.getRandomNumber();
		String Industry=eUtil.readDataFromExcelSheet("Organization", 4, 3);
		Reporter.log("--Read the data--");
		
		
		//Step 2: Click on OrganizationLink
		
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationLink();
		Reporter.log("--Organization link clicked--");
		
		//Step 3: Click on Organization Lookup icon
		
		 OrganizationPage op=new  OrganizationPage(driver);
		 op.clickOnOrglookUpIcon();
		 Reporter.log("--Lookup icon clicked--");
		
		//Step 4 : Create new Organization with Mandatory fields and Industry and save 
		 
		CreateNewOrganizationPage CnO=new CreateNewOrganizationPage(driver);
		CnO.CreatNewOrganization(ORGName, Industry);
		Reporter.log("-Organization Created with Industry--");
		
		//Step 5: validate 
		
		OrganizationInformationPage oi=new OrganizationInformationPage(driver);
		String orgHeader = oi.getOrganizationHeader();
		Assert.assertTrue(orgHeader.contains(ORGName));
		//Assert.fail();
		System.out.println(orgHeader);
		
	    
	  }
	    @Test(groups = "RegressionSuite")
	
    public void test3() {
		System.out.println("Hello");
		System.out.println("Execution");
		System.out.println("Passed");
		
		}  

}
