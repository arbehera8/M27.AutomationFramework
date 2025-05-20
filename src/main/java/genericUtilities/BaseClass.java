package genericUtilities;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.InventoryPage;
import objectRepository.LoginPage;

/**
 * 
 */
public class BaseClass {
	
	// Create objects of utilities
			public FileUtility futil = new FileUtility();
			public JavaUtility jutil = new JavaUtility();
			public SeleniumUtility sutil = new SeleniumUtility();
			public WebDriver driver;
			public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig() {
		System.out.println("=====DataBase Connection Successfull=======");
	}
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig() throws FileNotFoundException, IOException {
		
		       String URL = futil.readDataFrompropertyFile("url");
		       //Launch the browser
				//driver = new ChromeDriver();
		       //driver = new FirefoxDriver();
		       
		       driver = new EdgeDriver();
		       
		       //Cross bowser testing - "Runtime polymorphism - driver"
		       
				/*
				 * if(pValue.equals("edge")) { driver = new EdgeDriver(); } else
				 * if(pValue.equals("firefox")) { driver = new FirefoxDriver(); } else { driver
				 * = new EdgeDriver(); }
				 */
		    		   
		       
				sutil.maximizeWindow(driver);
				sutil.addImplicitlyWait(driver);
				//Load the URL
				driver.get(URL);
				sdriver = driver;
				System.out.println("Bowser launch successfull");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws FileNotFoundException, IOException {
		String USERNAME= futil.readDataFrompropertyFile("username");
		String PASSWORD= futil.readDataFrompropertyFile("password");
		//Login to the application

		LoginPage lp = new LoginPage(driver);
		lp.logintoApp(USERNAME, PASSWORD);
		System.out.println("Login to the App successfull");
		
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() {
		
		InventoryPage ip = new InventoryPage(driver);
		ip.logOutOfApp();
		System.out.println("Logout of App successfull");
		
	}
	
	@AfterTest
	//@AfterClass(alwaysRun = true)
	public void acConfig() {
		
		driver.quit();
		System.out.println("Browser closure successfull");
		
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig() {
		
		System.out.println("=====DataBase Closure Successfull=======");
		
	}

}
