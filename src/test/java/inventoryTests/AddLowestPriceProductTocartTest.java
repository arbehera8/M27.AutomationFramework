package inventoryTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;

public class AddLowestPriceProductTocartTest extends BaseClass{

	@Test
	public void tc_01_AddProductToCart_With_LowPrice_Test() throws IOException {
		// TODO Auto-generated method stub
		// Create objects of utilities
		/*
		 * FileUtility futil = new FileUtility(); JavaUtility jutil = new JavaUtility();
		 * SeleniumUtility sutil = new SeleniumUtility();
		 * 
		 * 
		 * String USERNAME= futil.readDataFrompropertyFile("username"); String PASSWORD=
		 * futil.readDataFrompropertyFile("password"); String URL =
		 * futil.readDataFrompropertyFile("url");
		 */



		//Read data from excel file	
		String SORTOPTION = futil.readDataFromexcelFile("Products", 4, 2);
		String PRODUCTNAME = futil.readDataFromexcelFile("Products", 4,3);//is to be added

		/*
		 * //Launch the browser WebDriver driver = new ChromeDriver();
		 * sutil.maximizeWindow(driver); sutil.addImplicitlyWait(driver);
		 * 
		 * //Load the URL driver.get(URL);
		 * 
		 * //Login to the application
		 * 
		 * LoginPage lp = new LoginPage(driver); lp.logintoApp(USERNAME, PASSWORD);
		 */

		//Click On Product

		InventoryPage ip = new InventoryPage(driver);
		//ip.clickOnAProduct(driver, PRODUCTNAME);
		ip.clickOnLowestPriceProduct(driver, SORTOPTION, PRODUCTNAME);

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
	}


