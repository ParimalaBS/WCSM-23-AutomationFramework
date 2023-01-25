package vTiger.ObjectRepository;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement CreateContactImg;
	
	public ContactsPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	//Utilization

	public WebElement getCreateContactImg() {
		return CreateContactImg;
	}
	
	//Business Library
	public void clickOnContactImg() {
		CreateContactImg.click();
		
		
	}
	
	

}
