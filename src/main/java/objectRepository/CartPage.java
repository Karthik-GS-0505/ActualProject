package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	//Declaration
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	private WebElement productName;
	
	//Initialization
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getProductName() {
		return productName;
	}

	//Business Library
	/**
	 * This method is used to capture product name
	 * @param driver
	 * @param PRODUCTNAME
	 * @return product name
	 */
	//Capture product name
	public String CaptureProductName()
	{
		return getProductName().getText();
	}
}
