package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddproductToCart {

	public static void main(String[] args) throws IOException {
		
		//Read data From property file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String URL = prop.getProperty("url");
		String USERNAME= prop.getProperty("username");
		String PASSWORD= prop.getProperty("password");
		
		
		//Read data from excel file
		
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise); //document
		Sheet sh = wb.getSheet("Products"); //sheet
		Row row = sh.getRow(1); //row
		Cell cell = row.getCell(2); //cell
		String PRODUCTNAME = cell.getStringCellValue(); //product has to be added to the cart at run time
		
		//Launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Load the URL
		
		driver.get(URL);
		
		//Login to the app
		
	    driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("login-button")).click();

        // Click on the product - use the excel data - Dynamic xpath
		
		//WebElement link = driver.findElement(By.xpath("//div[contains(@class, 'inventory_item_name') and text()='Sauce Labs Backpack']"));
		//WebElement ele = driver.findElement(By.xpath("//div[.='Sauce Labs Backpack']"));
		WebElement ele = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']"));
		String productTobeAdded = ele.getText();
		ele.click();
		
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
