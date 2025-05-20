package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		WebElement username=driver.findElement(By.id("user-name"));
		WebElement password=driver.findElement(By.id("password"));
		WebElement login=driver.findElement(By.name("login-button"));
		username.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		login.click();
		WebElement link = driver.findElement(By.xpath("//div[contains(@class, 'inventory_item_name') and text()='Sauce Labs Backpack']"));
		link.click();
		Thread.sleep(2000);
		WebElement addToCart = driver.findElement(By.name("add-to-cart"));
		addToCart.click();
		Thread.sleep(1000);
		WebElement shoppingCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		shoppingCart.click();
		Thread.sleep(2000);
		 WebElement checkout = driver.findElement(By.id("checkout"));
		 checkout.click(); 
		 WebElement firstName =driver.findElement(By.id("first-name")); firstName.sendKeys("Arundhati");
		 WebElement lasttName = driver.findElement(By.id("last-name"));
		 lasttName.sendKeys("Behera"); 
		 WebElement postalCode =driver.findElement(By.id("postal-code")); postalCode.sendKeys("560027");
		 WebElement continueButton = driver.findElement(By.id("continue"));
		 continueButton.click(); 
		 WebElement finish = driver.findElement(By.id("finish"));
		 finish.click();
		 WebElement backtoHome = driver.findElement(By.id("back-to-products"));
		 backtoHome.click();
		 
		
		
		
		
      
	}

}
