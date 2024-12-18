package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPageAndMenu {
	
	//Declaration
	@FindBy(id = "react-burger-menu-btn")
	private WebElement menuButton;
	
	@FindBy(id = "logout_sidebar_link")
	private WebElement logoutButton;
	
	//Initialization
	public InventoryPageAndMenu(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//getters
	public WebElement getMenuButton() {
		return menuButton;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}
	
	//Business library
	/**
	 * This method is used to click on product name and capture title
	 * @param driver
	 * @param PRODUCTNAME
	 * @return product name
	 */
	public String ClickOnProductAndCaptureTitle(WebDriver driver,String PRODUCTNAME)
	{
		String productTitle = driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")).getText();
		driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")).click();
		
		return productTitle;
	}
	
	/**
	 * This method is used to logout from application
	 */
	public void clickOnLogout()
	{
		getMenuButton().click();
		getLogoutButton().click();
	}
}
