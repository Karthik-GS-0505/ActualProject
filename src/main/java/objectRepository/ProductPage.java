package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	//Declaration
	@FindBy(id = "add-to-cart")
	private WebElement addToCartButton;
	
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement cartIcon;
	
	//Initialization
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//getters
	public WebElement getAddToCartButton() {
		return addToCartButton;
	}
	
	public WebElement getCartIcon() {
		return cartIcon;
	}
	
	//Business Library
	/**
	 * This method is used to click on add to cart button
	 */
	public void clickOnAddToCartButton()
	{
		getAddToCartButton().click();
	}
	
	/**
	 * This method is used to navigate to cart or click on cart icon
	 */
	//navigate to cart
	public void navigateToCart()
	{
		getCartIcon().click();
	}
}
