package vTiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Target;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * this method consists of generic methods of webdriver actions
 * @author vijay
 *
 */

public class WebDriverUtility {
	/**
	 * This method will maximize the browser window  
	 * @param driver
	 */
	
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method will minimize the browser window 
	 * @param driver
	 */
	
	public void minimizeWindow(WebDriver driver) {
	driver.manage().window().minimize();
	}
	  /**
	   *This method will wait for 10 sec until  webpage get loaded  
	   * @param driver
	   */
	
	public void waitForpageLoad(WebDriver driver) {
		
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait until particular element become visible 
	 * @param driver
	 * @param element
	 */
	
	public void waitForElementToBeVisible(WebDriver driver,WebElement element) {
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));	
	}
	/**
	 * This method will wait until element to be clickable
	 * @param driver
	 * @param ele
	 */
	
	public void waitForElementToBeClickable(WebDriver driver,WebElement ele)
	{
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	/**
	 * This method will handle the dropdown by using index of the value
	 * @param element
	 * @param index
	 */
	
	public void handleDropdown(WebElement element,int index) {
		Select se=new Select(element);
		se.selectByIndex(index);
	}
	/**
	 * This method will handle dropdown using value
	 * @param ele
	 * @param value
	 */
	
	public void handleDropDown(WebElement ele,String value) {
		Select s= new Select(ele);
		s.selectByValue(value);
	}
	
	/**
	 * This method will handle dropdown using visible text
	 * @param text
	 * @param element
	 */
	
	public void handleDropdown( String text ,WebElement element) {
		Select s= new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * This method will move cursor on the target element
	 * @param driver
	 * @param ele
	 */
	
	public void mouseHovering(WebDriver driver,WebElement ele) {
		Actions actions= new Actions(driver);
		actions.moveToElement(ele).perform();
	}
	/**
	 * This method will drag the src element and drop into the target element 
	 * @param driver
	 * @param src
	 * @param target
	 */
	
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement  target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(src, target).perform();
	}
	/**
	 * This method will doubleclick on target webelement 
	 * @param driver
	 * @param ele
	 */
	public void doubleClick(WebDriver driver,WebElement ele) {
		Actions actions = new Actions(driver);
		actions.doubleClick(ele).perform();
	}
	/**
	 * This method will doubleclick on the webpage 
	 * @param driver
	 */
	public void doubleclick(WebDriver driver) {
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	 public void rightClick(WebDriver driver,WebElement ele) {
		 Actions act = new Actions(driver);
		 act.contextClick(ele).perform();
		 
	 }
	 /**
	  * This method will give the Screeshot of the webElement or webpage
	  * @param driver
	  * @param ScreenshotsName
	  * @return
	  * @throws IOException
	  */
	 public String takeScreenshot(WebDriver driver, String ScreenshotsName) throws IOException {
		 
		 TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(".//screenShots/"+ScreenshotsName+" .png");
		FileUtils.copyFile(src, dest);// from commons Io
		return dest.getAbsolutePath();// To get extent reports
		 
	 }
	
	
	
	/**
	 * This method will switch to frame using index of frame
	 * @param driver
	 * @param index
	 */
	
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	/** 
	 * This method will switch to frame using nameORid
	 * @param driver
	 * @param Id
	 */
	public void switchToFrame(WebDriver driver,String nameORid ) {
		driver.switchTo().frame(nameORid);		
	}
	/**
	 * This method will switch tp parent frame
	 * @param driver
	 */
	
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch back to default content frame
	 */
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	 /**
	 * This method will accpet the alertPopup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		
		driver.switchTo().alert().accept();
	}
	/** 
	 * This method will dismiss the alertpopup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will capture the text of the popup and return it to caller
	 * @param driver
	 * @return 
	 */
	
	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	public void switchToWindow(WebDriver driver, String PartialTitle) {
		//capture all window IDs
		Set<String> windowIds = driver.getWindowHandles();
		// Extract  Individual window IDs
		for (String WinId : windowIds) {
			
		//Capture the cuurent window title
			
			String currentWinTitle = driver.switchTo().window(WinId).getTitle();
		//Compare with current window title with required title
			
			if (currentWinTitle.contains(PartialTitle)) {
				
				break;
			}
		}
		
	}
	
	/**
	 * This method will do Scrolling Actions
	 * @param driver
	 */
			public void scrollBarAction(WebDriver driver) {
				
				JavascriptExecutor js= ( JavascriptExecutor)driver ;
				js.executeScript("window.scrollBy(0,500)");
			}
			/**
			 * This method will handle the scrollbar 
			 * @param driver
			 * @param element
			 */
			
			public void handleScrollbar(WebDriver driver, WebElement element) {
				
				JavascriptExecutor js=(JavascriptExecutor) driver;
				int Y = element.getLocation().getY();
				
				js.executeScript("window.scrollBy(0,"+Y+")", element);	
			}
					
}
		
		
       
	

