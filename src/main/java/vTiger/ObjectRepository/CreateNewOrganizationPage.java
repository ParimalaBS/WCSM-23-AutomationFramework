package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {
	
	@FindBy(name = "accountname")
	private WebElement OrgNameTextfield;
	
	@FindBy(id = "employees")
	private WebElement EmployeeTextField; 
	
	@FindBy(id = "email2")
	private  WebElement emailTextField;
	
	@FindBy(name = "industry")
	private WebElement IndustryDrpdwn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameTextfield() {
		return OrgNameTextfield;
	}

	public WebElement getEmployeeTextField() {
		return EmployeeTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getIndustryDrpdwn() {
		return IndustryDrpdwn;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//Bussiness code
	public void CreatNewOrganization(String OrgName,String Industry) {
		OrgNameTextfield.sendKeys(OrgName);
		//EmployeeTextField.sendKeys(num);
		//emailTextField.sendKeys(email);
		handleDropDown(IndustryDrpdwn, Industry);
		SaveBtn.click();
    }
	
	public void CreateNewOrganization(String OrgName) {
		OrgNameTextfield.sendKeys(OrgName);
		SaveBtn.click();
	   }
	
	
	

}
