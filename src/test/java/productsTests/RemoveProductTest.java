package productsTests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;

@Listeners(genericUtilities.ListnersImplementation.class)
public class RemoveProductTest extends BaseClass{
	@Test(groups="Regression")
	public void tc_002_removeProductTest()
	{
		System.out.println("Product removed");
	}
}
