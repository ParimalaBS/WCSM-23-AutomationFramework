package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement CreateORGImage;

	
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateORGImage() {
		return CreateORGImage;
	}
	
	//Bussiness Library
	
	public void clickOnOrglookUpIcon() {
		
		CreateORGImage.click();
		
	}

}
