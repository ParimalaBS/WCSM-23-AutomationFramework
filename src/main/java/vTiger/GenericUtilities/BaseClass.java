package vTiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

/**
 * This class contains all Basic Configuration
 * @author Shivunayak
 *
 */

public class BaseClass {
	
	public JavaUtility jUtil= new JavaUtility();
	public PropertyFileUtility pUtil= new PropertyFileUtility();
	public ExcelUtility eUtil=new ExcelUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public WebDriver driver=null;
	public static WebDriver Sdriver;
	
	
	
	@BeforeSuite(groups = "Smokesuite")
	public void  dataBaseConnection() {
		
		System.out.println("---Database connection Successful----");
	}
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups = "Smokesuite")
	public void  LaunchBrowser() throws IOException {
		
		String Browser = pUtil.readDataFromPropertyFile("browser");
		
		String URL = pUtil.readDataFromPropertyFile("url");
		
		if (Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			Sdriver=driver;
			System.out.println(Browser+ " Launched Sucessfully");
			}
		else if(Browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			Sdriver=driver;
			System.out.println(Browser +"  Launched successfully");
		}
		else {
			System.out.println("Invalid browser name");
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForpageLoad(driver);
		driver.get(URL);
	}
		@BeforeMethod(groups = "Smokesuite")
		public void loginToApp() throws IOException {
			
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String Pwd = pUtil.readDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.LoginToApp(USERNAME, Pwd);
		System.out.println("Login To the Application");
		}
		
		@AfterMethod(groups = "Smokesuite")
		public void Logout() {
			HomePage hp =new HomePage(driver);
		hp.LogoutFromApp(driver);
			System.out.println("successfully logout");
			
		}
		//@AfterTest
		@AfterClass(groups = "Smokesuite")
		public void closeBrowser() {
			driver.quit();
			System.out.println("browser closed");
		}
		
		@AfterSuite(groups = "Smokesuite")
		public void CloseDBconnection() {
			System.out.println("---- Close the DatabaseConnection-----");
		
		}
}


