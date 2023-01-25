package Vtiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VtigerCreateOrganization {

	public static void main(String[] args) {
		//Step 1: Launch the browser 
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		//Step 2: Login the Application
		WebElement usernameTextField = driver.findElement(By.name("user_name"));
		usernameTextField.sendKeys("admin");
		WebElement passwordTextField = driver.findElement(By.name("user_password"));
		passwordTextField.sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3: Click on Organization link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 4: Click on Create organization lookup icon
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		
		//Step 5: Create Organization with Mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("Qspiders");
		driver.findElement(By.id("employees")).sendKeys("2000");
		WebElement indusrtyDropdown = driver.findElement(By.name("industry"));
		Select select =new Select(indusrtyDropdown);
		select.selectByValue("Banking");
		Select typeDropdown = new Select(driver.findElement(By.name("accounttype")));
		typeDropdown.selectByIndex(2);
		driver.findElement(By.cssSelector("input[value='T']")).click();
		Select assignToDrpdwn= new Select(driver.findElement(By.name("assigned_group_id")));
		assignToDrpdwn.selectByVisibleText("Support Group");
		driver.findElement(By.name("emailoptout")).click();
		driver.findElement(By.xpath("//b[.='Copy Shipping address']")).click();
		
	    //Step 6: click on Save 
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		//Step 7: Verify Organization is created or not 
		String OrganizationHeader = driver.findElement(By.className("dvHeaderText")).getText();
		if(OrganizationHeader.contains("Qspiderss")) {
			System.out.println(OrganizationHeader);
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
		
		//Step: 8 Logout of the Application
		Actions actions=new Actions(driver);
		WebElement menuOption = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		actions.moveToElement(menuOption).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

		
		
	}

}
