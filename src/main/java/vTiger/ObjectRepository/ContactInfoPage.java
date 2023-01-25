package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ContactHeader;
	
	
	public void ContactInfopage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getContactheader() {
		return ContactHeader;
	}
	
	//business Library
	
	public String getContactheaderText() {
		return ContactHeader.getText();
		
	}

}
