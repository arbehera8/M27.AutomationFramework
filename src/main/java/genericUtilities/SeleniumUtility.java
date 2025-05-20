package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.io.FileHandler;

/**This class consists of basic methods for Selenium tool
 * @author Arundhati
 */

public class SeleniumUtility {
	
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
		
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
		
	}
	
	/**
	 * This method will add 10 secs of implicitly wait
	 * @param driver
	 */
	public void addImplicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	/**
	 * This method will add 10 secs for particular element to be visible
	 * @param driver
	 * @param element
	 */
	public void explicitWait(WebDriver driver, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	/**
	 * This method will add 10 secs for particular element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElemenetToBeClickable(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	/**
	 * This method will add 10 secs for particular element to be selected
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeSelectable(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeSelected(element));

	}
	
	/**
	 * This method will handle drop down by index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	/**
	 * This method will handle drop down by visible text
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	/**
	 * This method will handle drop down by value
	 * @param element
	 * @param index
	 */
	public void handleDropDown(String value,WebElement element) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	/**
	 * This method will perform mouseHover action
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();	
	}
	
	/**
	 * This method will perform click and hold action
	 * @param driver
	 */
	public void mouseHoverActionClickAndHold(WebDriver driver) {
		Actions action = new Actions(driver);
		action.clickAndHold().perform();	
	}
	

	/**
	 * This method will help in double click action
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver) {
		Actions action = new Actions(driver);
		action.doubleClick().perform();;	
	}

	/**
	 * This method will help in right click action
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver,WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
		
	}
	
	/**
	 * This method will help in drag and drop action
	 * @param driver
	 */
	public void dragAndDropAction(WebDriver driver,WebElement sourceElement,WebElement targetElement) {
		Actions action = new Actions(driver);
		action.dragAndDrop(sourceElement, targetElement).perform();
		
	}

	/**
	 * This method will help in scroll to element
	 * @param driver
	 */
	public void scrollToElement(WebDriver driver,WebElement element) {
		Actions action = new Actions(driver);
		action.scrollToElement(element).perform();
		
	}
	
	/**
	 * This method will handle frame by frameName
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrame(WebDriver driver, String framenameOrID) {
		driver.switchTo().frame(framenameOrID);
	}
	
	/**
	 * This method will handle frame by index
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrame(WebDriver driver, int frameIndex) {
		driver.switchTo().frame(frameIndex);
	}
	
	/**
	 * This method will handle frame with frameElements
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method will accept alert pop up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss pop up
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will get text from alert pop up
	 * @param driver
	 */
	public void acceptAlerttext(WebDriver driver) {
		
		driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will capture the text from alert pop up
	 * @param driver
	 */
	public void enterAlerttext(WebDriver driver, String text) {
		
		driver.switchTo().alert().sendKeys(text);
	}
	
	/**
	 * This method will get text from alert pop up
	 * @param driver
	 */
	public void getAlerttext(WebDriver driver) {
		
		driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will capture screenshot and return the path to the caller
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	
	public String captureScreenshot(WebDriver driver, String screenshotName) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShots\\"+ screenshotName + ".png");
		FileHandler.copy(src, dst);
		return dst.getAbsolutePath(); // For Extent Reports
		
	}
	
	
}
