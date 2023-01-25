package Vtiger.Practice;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithIndustryDataProvider {
	
	@Test(dataProvider = "getOrgNameData")
	public void createOrganizationTest(String OrgName, String IndustryName) {

	//Step 1: Launch the Browser 
			WebDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			driver.get("http://localhost:8888");
			
			//Step 2: Login to The  Application 
			WebElement usernameTextField = driver.findElement(By.name("user_name"));
			usernameTextField.sendKeys("admin");
			WebElement passwordTextField = driver.findElement(By.name("user_password"));
			passwordTextField.sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			
			//Step 3: click on organization link
			driver.findElement(By.linkText("Organizations")).click();
			
			//Step 4: click on Create organization lookup icon
			driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
			
			//Step5:  Create Organization with mandatory fields
			driver.findElement(By.name("accountname")).sendKeys(OrgName);
			//Step 6: Select Energy in the Industry dropdown
			WebElement indusrtyDropdown = driver.findElement(By.name("industry"));
			Select select =new Select(indusrtyDropdown);
			select.selectByValue(IndustryName);
			
			//Step 8: click on save button
			driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
			
			//Step 7: Verify Organization is created or not 
			String OrganizationHeader = driver.findElement(By.className("dvHeaderText")).getText();
			if(OrganizationHeader.contains(OrgName)) {
				System.out.println(OrganizationHeader);
				System.out.println("PASS");
			}else {
				System.out.println("FAIL");
			}
	}
			@DataProvider()
			public Object[][] getOrgNameData() {
				
			Object [][] data=new Object[5][2];
			 data[0] [0]="karnataka";
			 data[0][1]="Banking";
			 
			 data[1] [0]="Mysore";
			 data[1][1]="Chemicals";
			 
			 data[2] [0]="mandya";
			 data[2][1]="Education";
			 
			 data[3] [0]="managalore";
			 data[3][1]="Healthcare";
			 
			 data[4] [0]="kerala";
			 data[4][1]="Insurance";
				
			return data	;
				
			}
	
	
	
}
