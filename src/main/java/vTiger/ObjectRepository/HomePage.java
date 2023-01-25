package vTiger.ObjectRepository;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement Contactslink;
	
	@FindBy(linkText = "Leads")
	private WebElement LeadsLink;
	
	@FindBy(linkText = "Products")
	private WebElement Productslink;
	
	@FindBy(name = "query_string")
	private WebElement SearchTextfield;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministrationImg;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement SingOutLink;
	
	// Create Constructor to initialize webelement/variables 
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationLink() {
		return OrganizationLink;
	}

	public WebElement getContactslink() {
		return Contactslink;
	}

	public WebElement getLeadsLink() {
		return LeadsLink;
	}

	public WebElement getProductslink() {
		return Productslink;
	}

	public WebElement getSearchTextfield() {
		return SearchTextfield;
	}
	
	
	public WebElement getAdministrationImg() {
		return AdministrationImg;
	}

	public WebElement getSingOutLink() {
		return SingOutLink;
	}
	//Bussines library-generic method

	public void clickOnOrganizationLink() {
		OrganizationLink.click();
		
	}
	
	 public void clickOnContactslink() {
		Contactslink.click();
	 }
	 
	  public void LogoutFromApp(WebDriver driver) {
		 
		mouseHovering(driver, AdministrationImg);
		SingOutLink.click();
		 
 }
	
	
	
	
}
