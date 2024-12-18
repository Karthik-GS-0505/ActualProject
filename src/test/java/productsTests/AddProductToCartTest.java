package productsTests;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

//dynamic xpath - changing value(eg:-text()='value') in xpath it navigates to new product Eg.. PRODUCTNAME
//Using DDT,GU,POM
import java.io.IOException;
import genericUtilities.BaseClass;
import objectRepository.CartPage;
import objectRepository.InventoryPageAndMenu;
import objectRepository.ProductPage;

@Listeners(genericUtilities.ListnersImplementation.class)
public class AddProductToCartTest extends BaseClass{
	
	@Test(groups="smoke")
	public void tc_001_AddProductToCartTest() throws IOException, InterruptedException {

		//Read Test data from Excel file
		String PRODUCTNAME = eUtil.readDataFromExcel("Product",1,2);
		//System.out.println(10/0); //to fail TC -to capture exception by Listners

		//Step1:- Navigate to Inventory Page and capture the title 
		InventoryPageAndMenu ipm = new InventoryPageAndMenu(driver);
		String productAddedToCart = ipm.ClickOnProductAndCaptureTitle(driver, PRODUCTNAME);
		System.out.println("productAddedToCart -"+productAddedToCart);
		Thread.sleep(2000);
		
		//Step2:- Navigate to product page and click on add to cart button	
		ProductPage pp = new ProductPage(driver);
		pp.clickOnAddToCartButton();
		Thread.sleep(2000);
		
		//Step3:- Navigate to cart
		pp.navigateToCart();
		Thread.sleep(2000);
		//Assert.fail(); //to fail TC -to capture exception by Listners

		//Step4:- capture product info from cart
		CartPage cp = new CartPage(driver);
		String actProductInCart = cp.CaptureProductName();
		System.out.println("actProductInCart -"+actProductInCart);
		
		//Step5:- Validate for product name
		SoftAssert sa = new SoftAssert();
		//Assert.fail();
		sa.assertEquals(actProductInCart, productAddedToCart);
		//sa.assertAll();
		System.out.println("product Added To Cart ->"+productAddedToCart);
	}
}
