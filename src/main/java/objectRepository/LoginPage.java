package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //rule 1 - Declaration

	//Rule 2 - Initialization
	@FindBy(id = "user-name")
	private WebElement userNameEdt;
	
	@FindBy(id = "password")
	private WebElement passwordEdt;
	
	@FindBy(id = "login-button")
	private WebElement loginBtn;
	
	//Rule 3 - utilization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);  //PageFactory is a utility that helps initialize the @FindBy //"this" keyword hold current object created i.e..ip 
	}										     //LoginPage constructor will bind all WebElement's with driver.

	//Rule 4 - Declaration
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Business library - business logic in generic method
	/**
	 * This method is used to login to application
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME,String PASSWORD)
	{
		getUserNameEdt().sendKeys(USERNAME);
		getPasswordEdt().sendKeys(PASSWORD);
		getLoginBtn().click();
	}
}
