package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage {
	
	@FindBy (xpath ="//button[.='Add to cart']") 
	private WebElement addToCart;
	
	@FindBy (className ="inventory_details_price") 
	private WebElement productPrice;
	
	public WebElement getAddToCart() {
		return addToCart;
	}

	public WebElement getProductPrice() {
		return productPrice;
	}
	
	//Rule 3 initialization
	
	public InventoryItemPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
	}
	
	//Business Library
	
	/**
	 * This method will add to cart button
	 */
	public void clickOnAddTocartBtn() {
		
		addToCart.click();
	}
	

}
