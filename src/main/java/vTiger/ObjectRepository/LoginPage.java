package vTiger.ObjectRepository;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class LoginPage {
		 
			//Rule 1: Create a class for every webPage of the Application 
			
			//Rule 2: Classname should be Title of the webpage 
			
			//Rule 3: Identify the elements Using @FindBy @Findall @FindBys annotations 
			
			@FindBy(name ="user_name") 
			private WebElement UsernameEdt;
			
			@FindBy(name="user_password")
			private WebElement passwordEdt;
			
			@FindBy(id="submitButton")
			private WebElement LoginBtn;
			
			//Rule 4: Create A Constructor To Initialize the variable / WebElement 
			
			public LoginPage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
			
			//Rule 5: provide Getters to access the WebElements

			public WebElement getUsernameEdt() {
				return UsernameEdt;
			}

			public WebElement getPasswordEdt() {
				return passwordEdt;
			}

			public WebElement getLoginBtn() {
				return LoginBtn;
			}
			
			//Rule 6: Create Bussiness Library
			
			public void LoginToApp(String Username,  String password) {
				UsernameEdt.sendKeys(Username);
				passwordEdt.sendKeys(password);
				LoginBtn.click();
			}
			
			
	}


