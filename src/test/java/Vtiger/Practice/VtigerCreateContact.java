package Vtiger.Practice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class VtigerCreateContact {

	public static void main(String[] args) {
		//Step 1: Launch browser
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		//Step 2: Login to the Application
		WebElement usernameTextField = driver.findElement(By.name("user_name"));
		usernameTextField.sendKeys("admin");
		WebElement passwordTextField = driver.findElement(By.name("user_password"));
		passwordTextField.sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3: click on Contact link
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//Step 4: click on Contact lookup icon 
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//Step 5: Create conctact with providing mandatory fields
		Select select = new Select(driver.findElement(By.name("salutationtype")));
		select.selectByValue("Ms.");
		driver.findElement(By.name("firstname")).sendKeys("ParimalaBS");
		driver.findElement(By.name("lastname")).sendKeys("pari");
		driver.findElement(By.id("email")).sendKeys("parimalanayak29@gmail.com");
		WebElement groupRadioButton = driver.findElement(By.xpath("//input[@value='T']"));
		groupRadioButton.click();
		Select select1=new Select(driver.findElement(By.name("assigned_group_id")));
		select1.selectByVisibleText("Support Group");
		driver.findElement(By.name("mobile")).sendKeys("9620550638");
		driver.findElement(By.name("reference")).click();
		
		// Step 6 : Save 
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		//Step 7 : validate 
		String HeaderText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(HeaderText.contains("Pari")) {
			System.out.println(HeaderText);
			System.out.println("PASS");
		  }else
		   {
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
