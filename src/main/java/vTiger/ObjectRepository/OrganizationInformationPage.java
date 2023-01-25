package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgHeadertext;
	
	@FindBy(name = "Edit")
	private WebElement EditBtn;
	
	@FindBy(name = "Duplicate")
	private WebElement DuplicateBtn;
	
	@FindBy(name = "Delete")
	private WebElement DeleteBtn;
	
	
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getOrgHeadertext() {
		return OrgHeadertext;
	}


	public WebElement getEditBtn() {
		return EditBtn;
	}


	public WebElement getDuplicateBtn() {
		return DuplicateBtn;
	}


	public WebElement getDeleteBtn() {
		return DeleteBtn;
	}
	//Bussiness Library
	
	public String  getOrganizationHeader() {
		return OrgHeadertext.getText();
		
	}
	
	
	
	
	
}
