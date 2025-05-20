package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	
	//rule 2
			@FindBy (className ="inventory_item_name") 
			private WebElement itemInfo;
			
			@FindBy (xpath ="//button[.='Remove']") 
			private WebElement removeBtn;
		
		//Rule 3 initialization
	
		public CartPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		}
		
		public WebElement getItemInfo() {
			return itemInfo;
		}

		public WebElement getRemoveBtn() {
			return removeBtn;
		}
		
		//Business Library
		
		public String getItemName() {
			return itemInfo.getText();
		}
		
		/**
		 * This method will click on remove Button
		 */
		 public void clickObRemoveBtn() {
			 removeBtn.clear();
		 }
		
		

}
