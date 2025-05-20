package inventoryTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class AddProductToCartTest extends BaseClass{

	@Test(groups = "SmokeSuite")
	 public void tc_01_AddProductToCartTest() throws IOException {

		//Read data from excel file	      
		String PRODUCTNAME = futil.readDataFromexcelFile("Products", 1, 2); //has to be added

		//Click On Product

		InventoryPage ip = new InventoryPage(driver);
		ip.clickOnAProduct(driver, PRODUCTNAME);

		//Add Product To Cart

		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddTocartBtn();

		ip.clickOnCartContainer();

		//validate on cart

		CartPage cp = new CartPage(driver);
		String productInCart = cp.getItemName();

		/*
		 * if(productInCart.equals(PRODUCTNAME)) { System.out.println("PASS");
		 * System.out.println(productInCart);
		 * 
		 * }else { System.out.println("FAIL"); }
		 */
		
		Assert.assertEquals(productInCart, PRODUCTNAME);
		Assert.assertTrue(productInCart.equals(PRODUCTNAME));
		System.out.println(productInCart);

	}
	
	
	  @Test public void sampleTest() { 
		  
		  //Assert.fail();
		  System.out.println("Sample Test");
	  
	  }
	 

}
