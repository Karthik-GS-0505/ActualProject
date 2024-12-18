package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of generic methods related to selenium
 * @author Karthik
 */
public class SeleniumUtilities {
	
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimize(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will add implicit waits to the browser
	 * @param driver
	 */
	public void addImplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	/**
	 * This method will wait for the element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForMethodToBeClickable(WebDriver driver,WebElement ele)
	{
		WebDriverWait explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	/**
	 * This method will wait for the element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement ele)
	{
		WebDriverWait explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	/**
	 * This method is used to handle dropdown by index
	 * @param ele
	 * @param index
	 */
	public void handleDropDOwn(WebElement ele,int index)
	{
		Select s = new Select(ele);
		s.selectByIndex(index);
	}
	
	/**
	 *  This method is used to handle dropdown by value
	 * @param ele
	 * @param value
	 */
	public void handleDropDOwn(WebElement ele,String value)	//Overloading
	{
		Select s = new Select(ele);
		s.selectByValue(value);
	}
	
	/**
	 * This method is used to handle dropdown by visible Text
	 * @param ele
	 * @param visiableText
	 */
	public void handleDropDOwn(String visiableText,WebElement ele) //Overloading
	{
		Select s = new Select(ele);
		s.selectByVisibleText(visiableText);
	}
	
	/**
	 * This method is used to for mouse hover a element action
	 * @param driver
	 * @param ele
	 */
	public void mouseHoverAction(WebDriver driver,WebElement ele)
	{
		Actions a = new Actions(driver);
		a.moveToElement(ele);
	}
	
	/**
	 * This method is used to handle scroll from origin
	 * @param driver
	 * @param ele
	 * @param x
	 * @param y
	 */
	public void scrollFromOrigin(WebDriver driver,WebElement ele,int x,int y)
	{
		Actions a = new Actions(driver);
		ScrollOrigin so = ScrollOrigin.fromElement(ele);
		a.scrollFromOrigin(so, x, y).perform();
	}
	
	/**
	 * This method is used for right Click Action
	 * @param driver
	 * @param ele
	 */
	public void rightClickAction(WebDriver driver,WebElement ele)
	{
		Actions a = new Actions(driver);
		a.contextClick(ele);
	}
	
	/**
	 * This method is used for double Click Action
	 * @param driver
	 * @param ele
	 */
	public void doubleClick(WebDriver driver,WebElement ele)
	{
		Actions a = new Actions(driver);
		a.doubleClick(ele);
	}
	
	/**
	 * This method is used for Click and Hold Action
	 * @param driver
	 * @param ele
	 */
	public void ClickAndHold(WebDriver driver,WebElement ele)
	{
		Actions a = new Actions(driver);
		a.clickAndHold(ele);
	}
	
	/**
	 * This method is used for Click and Hold Action
	 * @param driver
	 * @param dragele
	 * @param desloc
	 */
	public void DragAndDrop(WebDriver driver,WebElement dragele,WebElement desloc)
	{
		Actions a = new Actions(driver);
		a.dragAndDrop(dragele,desloc);
	}
	
	/**
	 * This method is used for accept Alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method is used for dismiss Alert
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method is used for send keys to alert 
	 * @param driver
	 */
	public void sendKeysToAlert(WebDriver driver,String alertMsg)
	{
	    driver.switchTo().alert().sendKeys(alertMsg);
	}
	
	/**
	 * This method is used to get alert text
	 * @param driver
	 */
	public void getAlertText(WebDriver driver)
	{
	    driver.switchTo().alert().getText();
	}
	
	/**
	 * This method is used to switch to frame using index value
	 * @param driver
	 * @param frame index
	 */
	public void handleFrame(WebDriver driver,int frameIndex) 
	{
		driver.switchTo().frame(frameIndex);
	}
	
	/**
	 * This method is used to switch to frame using nameOrId value
	 * @param driver
	 * @param frame nameOrId
	 */
	public void handleFrame(WebDriver driver,String frameNameOrId) //method overloading
	{
		driver.switchTo().frame(frameNameOrId);
	}
	
	/**
	 * This method is used to switch to frame using WebElement value
	 * @param driver
	 * @param frame element
	 */
	public void handleFrame(WebDriver driver,WebElement frameEle) //method overloading
	{
		driver.switchTo().frame(frameEle);
	}
	
	/**
	 * This method is used to switch to default content frame
	 * @param driver
	 */
	public void switchToDefaultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method is used to switch to parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method is used to switch to Window
	 * @param driver
	 */
	public void switchToWindow(WebDriver driver,String WindowID)
	{
		driver.switchTo().window(WindowID);
	}
	
	/**
	 * This method will capture the screenshot
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver,String screenShotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destiny = new File(".\\ScreenShots\\"+screenShotName+".png");
		FileHandler.copy(source, destiny);
		
		return destiny.getAbsolutePath(); //Attach to extend reports
	}
}
