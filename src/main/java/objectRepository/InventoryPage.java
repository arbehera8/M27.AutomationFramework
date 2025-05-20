package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class InventoryPage extends SeleniumUtility{
	
	  //Declaration
	
		@FindBy (className ="product_sort_container") 
		private WebElement sortDropDown;
		
		@FindBy (id="shopping_cart_container") 
		private WebElement cartcontainerBtn;
		
		@FindBy (id="react-burger-menu-btn") 
		private WebElement menuBtn;
		
		//@FindBy(linkText="Logout")
		@FindBy (xpath ="//a[.='Logout']")
		private WebElement logoutLnk;
		
		public WebElement getSortDropDown() {
			return sortDropDown;
		}

		public WebElement getCartcontainerBtn() {
			return cartcontainerBtn;
		}

		public WebElement getMenuBtn() {
			return menuBtn;
		}

		public WebElement getLogoutLnk() {
			return logoutLnk;
		}
	   
		
		//Rule 3 initialization
		
		public InventoryPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		
		/**
		 * This method will click any product specified by caller
		 * @param driver
		 * @param productName
		 */
		//Business logic
		public void clickOnAProduct(WebDriver driver, String productName) {

			driver.findElement(By.xpath("//div[.='"+productName+"']")).click();			

		}

		/**
		 * This method will perform logout operation
		 */
		public void logOutOfApp() {

			menuBtn.click();
			logoutLnk.click();
		}
		
		/**
		 * This method will sort for lowest price product and then click on it
		 * @param driver
		 * @param sortOption
		 * @param productName
		 */
		
		public void clickOnLowestPriceProduct(WebDriver driver, String sortOption, String productName) {
			
			handleDropDown(sortDropDown, sortOption);
			driver.findElement(By.xpath("//div[.='"+productName+"']")).click();
		}
		
		/**
		 * This method will click on cart container button
		 */
		
		public void clickOnCartContainer() {
			cartcontainerBtn.click();
		}


}
