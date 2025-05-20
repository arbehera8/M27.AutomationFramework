package practice;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;

public class AddProductToCartWithUtility {
	
	public static void main(String[] args) throws FileNotFoundException,IOException {
		
		// Create objects of utilities
		FileUtility futil = new FileUtility();
		JavaUtility jutil = new JavaUtility();
		SeleniumUtility sutil = new SeleniumUtility();
		
		     //Read data From property file
		
		      String USERNAME= futil.readDataFrompropertyFile("username");
		      String PASSWORD= futil.readDataFrompropertyFile("password");	
		      String URL = futil.readDataFrompropertyFile("url");
		      				
				//Read data from excel file	      
		       String PRODUCTNAME = futil.readDataFromexcelFile("Products", 1, 2); //has to be added
				
				//Launch the browser
				WebDriver driver = new ChromeDriver();
				sutil.maximizeWindow(driver);
				sutil.addImplicitlyWait(driver);
				
				//Load the URL
				driver.get(URL);
				
				//Login to the app
				
				/*
				 * driver.findElement(By.id("user-name")).sendKeys(USERNAME);
				 * driver.findElement(By.id("password")).sendKeys(PASSWORD);
				 * driver.findElement(By.name("login-button")).click();
				 */
				
				LoginPage lp = new LoginPage(driver);
//				lp.getUsernameEdt().sendKeys(USERNAME);
//				lp.getPasswordEtd().sendKeys(PASSWORD);
//				lp.getLoginBtn().click();
				lp.logintoApp(USERNAME, PASSWORD);

		        // Click on the product - use the excel data - Dynamic xpath
				
				//WebElement link = driver.findElement(By.xpath("//div[contains(@class, 'inventory_item_name') and text()='Sauce Labs Backpack']"));
				//WebElement ele = driver.findElement(By.xpath("//div[.='Sauce Labs Backpack']"));
				WebElement ele = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']"));
				String productTobeAdded = ele.getText();
				ele.click();
				
				//capture screenshot
				String screenshot = "addProductsToCart" + jutil.getSystemDate();
				String path = sutil.captureScreenshot(driver, screenshot);
				System.out.println(path);
				
				//Add Product to cart
				driver.findElement(By.name("add-to-cart")).click();
				
				//Navigate to cart
				
				//driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
				 
				driver.findElement(By.id("shopping_cart_container")).click();
				
				//validate the product								 
				//WebElement addedProduct= driver.findElement(By.xpath("//div[.='Sauce Labs Backpack']"));
				
				WebElement addedProduct= driver.findElement(By.className("inventory_item_name"));
				
				String addedProductName= addedProduct.getText();
				
				if(addedProductName.equals(productTobeAdded)) {
					
					System.out.println("PASS");
					System.out.println(addedProductName);
					
				}else
				{
					System.out.println("FAIL");
				}
				
				//Logout from the console 
				
				driver.findElement(By.id("react-burger-menu-btn")).click();
				driver.findElement(By.linkText("Logout")).click();
				System.out.println("Logged Completed");

			}
	}
