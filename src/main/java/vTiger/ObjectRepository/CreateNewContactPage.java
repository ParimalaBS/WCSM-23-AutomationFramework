package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
	
	@FindBy(name = "lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath = "//input[@name='account_name']/../img[@alt='Select']")
	private WebElement OrgLookupIcon;
	
	@FindBy(name = "leadsource")
	private WebElement LeadsourceDrpdwn;
	
	@FindBy(id = "search_txt")
	private WebElement searchTextField;
	
	@FindBy(name = "search")
	private WebElement searchButton;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getOrgLookupIcon() {
		return OrgLookupIcon;
	}

	public WebElement getLeadsourceDrpdwn() {
		return LeadsourceDrpdwn;
	}
	
	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	// Business Library
	//Transfer the driver control
	public void createNewContactWithOrg(WebDriver driver,String  Lastname,String Orgname) {
		LastNameEdt.sendKeys(Lastname);
		OrgLookupIcon.click();
		switchToWindow(driver, "Accounts");
		searchTextField.sendKeys(Orgname);
		searchButton.click();
		driver.findElement(By.xpath("//a[text()='"+Orgname+"']")).click();
		switchToWindow(driver, "Contacts");
		SaveBtn.click();
	}
	
	public void createNewContactWithOrg(String LastName) {
		LastNameEdt.sendKeys(LastName);
		SaveBtn.click();
	}
		
}


