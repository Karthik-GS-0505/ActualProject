package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.InventoryPageAndMenu;
import objectRepository.LoginPage;

public class BaseClass {
	
	public PropertyFileUtilities pUtil  = new PropertyFileUtilities();
	public ExcelFileUtilities eUtil = new ExcelFileUtilities();
	public SeleniumUtilities sUtil = new SeleniumUtilities();
	
	public WebDriver driver;
	
	//For listners
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun=true)
	public void bsConfig()
	{
		System.out.println("--- Database Connection Successfull ---");
	}
	
//For Cross-Browser Execution
//	@Parameters("browser") 
//	@BeforeTest 
//	public void bcConfig(String PARAMETERVALUE) throws IOException 

	@BeforeClass(alwaysRun=true)
	public void bcConfig() throws IOException 
	{
		String URL = pUtil.readDataFromPropertyFile("url");
		
		/*For Cross-Browser Execution
		if(PARAMETERVALUE.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(PARAMETERVALUE.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		*/
		
		driver = new ChromeDriver();
		sUtil.maximize(driver);
		sUtil.addImplicitWait(driver);
		
		driver.get(URL);
		
		System.out.println("--- Browser Lauch Successfull ---");
		
		//For listners
		sdriver = driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("--- Login to App ---");
	}
	
	@AfterMethod(alwaysRun=true)
	public void amConfig()
	{
		InventoryPageAndMenu ipm = new InventoryPageAndMenu(driver);
		ipm.clickOnLogout();
		
		System.out.println(" --- logout of app ---");
	}
	
	@AfterClass(alwaysRun=true)
	public void acConfig()
	{
		driver.quit();
		
		System.out.println("--- Browser closure successfull ---");
	}
	
	@AfterSuite(alwaysRun=true)
	public void asConfig()
	{
		System.out.println("--- Database Connection Successfull ---");
	}
	
}