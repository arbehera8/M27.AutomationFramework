package objectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //rule 1
	
	
	//rule 2
	//Identify single webelement thru multiple locators - OR Operator
	//Auto-healing process
	
	//@FindAll
	//({@FindBy(id="user-name"),@FindBy(xpath="//input[@uname='user-name']")})
	//private WebElement userNameEdt1;
	
	//Identify single webelement thru multiple locators - AND Operator

   // @FindBys({@FindBy(id="user-name") ,@FindBy(xpath = "//input[@uname='user-name']")})
	//private WebElement userNameEdt2;
	
	
	@FindBy (id="user-name") 
	private WebElement userNameEdt;
	
	@FindBy (id="password") 
	private WebElement passwordEdt;
	
	@FindBy(name="login-button") 
	private WebElement loginBtn;
	
	//Rule 3 initialization
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Rule 4 Utilization
	public WebElement getUsernameEdt() {
		return userNameEdt;
	}
	
	//Rule 4 Utilization
		public WebElement getPasswordEtd() {
			return passwordEdt;
		}
		
		//Rule 4 Utilization
		public WebElement getLoginBtn() {
			return loginBtn;
		}
		
		//Business optimization - generic method
		
		/**
		 * This method will perform loginOperation
		 * @param un
		 * @param pwd
		 */
		
		public void logintoApp(String un,String pwd) {
			
			userNameEdt.sendKeys(un);
			passwordEdt.sendKeys(pwd);
			loginBtn.click();
		}
	
	
		
	

}
