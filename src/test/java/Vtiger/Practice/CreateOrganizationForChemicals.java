package Vtiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateOrganizationForChemicals {

	public static void main(String[] args) throws InterruptedException {
		//Step 1:Launch the Browser 
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		//Step 2: Login to the application
		WebElement usernameTextField = driver.findElement(By.name("user_name"));
		usernameTextField.sendKeys("admin");
		WebElement passwordTextField = driver.findElement(By.name("user_password"));
		passwordTextField.sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		// Step 3:click on organization option link 
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 4: click on Create organization lookup icon
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		
		//Step 5: Create Organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("QspidersBangalore");
		driver.findElement(By.name("website")).sendKeys("Qspiders.com");
		driver.findElement(By.id("employees")).sendKeys("2000");
	    //Step 6: Select Chemicals in Industry dropdown
		WebElement indusrtyDropdown = driver.findElement(By.name("industry"));
		Select select =new Select(indusrtyDropdown);
		select.selectByValue("Chemicals");
		Select typeDropdown = new Select(driver.findElement(By.name("accounttype")));
		typeDropdown.selectByIndex(3);
		driver.findElement(By.name("emailoptout")).click();
		driver.findElement(By.cssSelector("input[value='T']")).click();
		Select assignToDrpdwn= new Select(driver.findElement(By.name("assigned_group_id")));
		assignToDrpdwn.selectByVisibleText("Support Group");
		//enter billing address  data into all the fields
		driver.findElement(By.name("bill_street")).sendKeys("Bendaravadi village ,chamarajanagara taluq and district");
		driver.findElement(By.id("bill_pobox")).sendKeys("bendaravadi");
		driver.findElement(By.id("bill_city")).sendKeys("chamarajanagara");
		driver.findElement(By.id("bill_state")).sendKeys("karnataka");
		driver.findElement(By.id("bill_code")).sendKeys("571312");
		driver.findElement(By.id("bill_country")).sendKeys("India");
		//select copy billing address radio button
		driver.findElement(By.xpath("//b[text()='Copy Billing address']/../input")).click();
		
		//Step 7: click on save button
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

		//Step 8: Verify Organization is created or not 
				String OrganizationHeader = driver.findElement(By.className("dvHeaderText")).getText();
				if(OrganizationHeader.contains("Qspiderss")) {
					System.out.println(OrganizationHeader);
					System.out.println("PASS");
				}else {
					System.out.println("FAIL");
				}
		//Step 9: Logout of the Application
		Actions actions=new Actions(driver);
		WebElement menuOption = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		actions.moveToElement(menuOption).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
}
