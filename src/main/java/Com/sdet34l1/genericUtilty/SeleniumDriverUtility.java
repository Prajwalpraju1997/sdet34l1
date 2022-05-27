package Com.sdet34l1.genericUtilty;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * this is class is used to maintain all webdriver common actions
 * @author PRAJWAL
 *
 */

public class SeleniumDriverUtility {
	
	static WebDriverWait wait;	
	public Select select;
	public Actions act;
	static JavascriptExecutor js;
	static JavaClassFileUtility jutil=new JavaClassFileUtility();
	static Alert alert;
    public WebDriver driver;
	
	//public SeleniumDriverUtility(WebDriver staticdriver) {
	// TODO Auto-generated constructor stub

	/**
	 * This method is used to navigate to the application
	 * @param url
	 * @param driver
	 */
	public static void navigateApp(String url, WebDriver driver) {
		driver.get(url);
	}
	
	/**
	 * This method is used to maximize the browser and implicitly wait
	 * @param longTimeOut
	 * @param driver
	 */
	public void browsersetting(long longTimeOut, WebDriver driver) {
	
		maximizeBrowser(driver);
		waitTillPageLoad(longTimeOut, driver);
	}
	
	/**
	 * this method is used to maximize the browser
	 * @param driver
	 */
	public void maximizeBrowser(WebDriver driver) {		
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to implicitly wait till load
	 * @param longTimeOut
	 * @param driver
	 */
	public void waitTillPageLoad(long longTimeOut, WebDriver driver ) {
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
	}
	
	/**
	 * This method is used to mouseoveraction on element
	 * @param driver
	 * @param seleniumDriverUtility
	 */
	
	public void actionsClassInvoke(WebDriver driver,SeleniumDriverUtility seleniumDriverUtility) {
		 act=new Actions(driver);
	}
	/**
	 * This method is use to mouse hover on the element
	 * @param moreLink
	 * @param driver
	 */
	
	
	public void mousehoverOntheElement(WebElement moreLink, WebDriver driver) {
		act=new Actions(driver);
		act.moveToElement(moreLink).perform();
	}
	/**
	 * This method is used to double click the element 
	 * @param element
	 */
	public  void doubleClick(WebElement element) {
		
		act.doubleClick(element).perform();
	}
	
	/**
	 * this method is used close the browser
	 * @param driver
	 */
	
	public void quitbrowser(WebDriver driver) {
		driver.quit();
	}
	
	/**
	 * This method is used to wait the control till the particularelement is clickable
	 * @param element
	 */
	public void waitUntillElementClickable(WebElement element) {
	wait.until(ExpectedConditions.elementToBeClickable(element));	
	}
	
	/**
	 * This method is used to intilize wait instance
	 * @param driver
	 * @param timeout
	 */
	
	public  void explicitlyWait(WebDriver driver, long timeout) {
		wait=new WebDriverWait(driver, timeout);
	}
	
	/**
	 * This method is used to switch the window based on title
	 * @param driver
	 * @param partialText
	 */
	public void switchToWindowBasedOnTitle(WebDriver driver, String partialText) {
		Set<String> sessionsIDs = driver.getWindowHandles();
		for(String id:sessionsIDs)
		{
			driver.switchTo().window(id);
			if(driver.getTitle().contains(partialText))
			{
				break;
			}
		}
	}
/**
 * This method is used to intialize the select class
 * @param element
 */
public void intializeSelect(WebElement element) {
	
	select = new Select(element);
}
/**This method is used handle the dropdown by visibletext
 * This method is used 
 * @param element
 * @param visibletext
 */
public void dropDownHandleByVisibleText(WebElement element, String visibletext) {
	select.selectByVisibleText(visibletext);
}

/**
 * This method is used handle the dropdown by index
 * @param element
 * @param intex
 */

public void dropDownHandleByIndex(WebElement element, int index) {
	
	select.selectByIndex(index);
}
/**
 * This method is used handle the dropdown by value
 * @param element
 * @param value
 */

public void dropDownHandleByvalue(WebElement element, String value) {
	select.selectByValue(value);
}

/**
 * This method is used handle the switchtoframe by index
 * @param driver
 * @param index
 */
public void switchToFrame(WebDriver driver, int index)
{
	driver.switchTo().frame(index);
}

/**
 * This method is used to handle the switchtoframe by nameID
 * @param driver
 * @param nameID
 */
public void switchToFrame(WebDriver driver, String nameID) {
	
	driver.switchTo().frame(nameID);
}

/**
 * This method is used to handle switchtoframe by element
 * @param element
 * @param driver
 */
public void switchToFrame(String element ,WebDriver driver  ) {
	
	driver.switchTo().frame(element);
}

/**
 * This method is uesd to handle the switch back to mainframe
 * @param driver
 */

public void switchBackToHome(WebDriver driver) {
	driver.switchTo().defaultContent();
}
/**
 * This method is used handle the disable element and send the data and scroll page
 * @param driver
 */

public void intializeJs(WebDriver driver) {
	
js=(JavascriptExecutor) driver;
}
/**
 * This method is used to send the data
 * @param element
 * @param data
 */

public void enterDataThroughJs(WebElement element, String data) {
	
	js.executeScript("arguments[0].value=arguments[1]", element, data);
}
/**
 * This method is used to click the element
 * @param element
 */
public void clickThrouhgJs(WebElement element) {
	
	js.executeScript("arguments[0].click()",element);
}
/**
 * This method is used to Navigate the application
 * @param url
 */
public void navigateApplicationThroughJs(String url) {
	js.executeScript("window.location=arguments[0]", url);
}
/**
 * This method is used to scroll the page
 * @param height
 */

public void scrollToSpaceFieldHegiht(String height) {
	js.executeScript("window.scrollBy(0,"+height+")");
}
/**
 * This method is used to scroll the page to bottom
 */
public void scrooToBottom() {
	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
}
/**
 * This method is used to Scrool element 
 * @param element
 */
public void scroolTillElement(WebElement element) {
	js.executeScript("arguments[0].scrollIntoView()",element);
}
/**
 * This method is used to takescreenshoot
 * @param staticdriver 
 * @param fileName
 * @return 
 * @throws IOException
 */
public String takeScreenShot(WebDriver driver, String fileName, JavaClassFileUtility jutil) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dst=new File("./Screenshoot/"+fileName+"_"+jutil.dataTimeInFormat()+".png");
    FileUtils.copyFile(src, dst);
   return dst.getAbsolutePath();
}
/**
 * This method is used to handle the popup and accept popup
 * @param driver
 */
public void alertAccept(WebDriver driver) {
	driver.switchTo().alert().accept();
}
/**
 * This method is used to handle the popup and dismiss popup
 * @param driver
 */
public void alertDismiss(WebDriver driver) {
	driver.switchTo().alert().dismiss();

}
/**
 * This method is used to handle the popup and send the to popup page
 * @param driver
 * @param data
 */
public void alertSendData(WebDriver driver, String data) {
	driver.switchTo().alert().sendKeys(data);
}

/**
 * This method is used to handle the popup and getText
 * @param driver
 * @param data
 * @return
 */
public  String alertText(WebDriver driver, String data) {
	return driver.switchTo().alert().getText();
}
/**
 * This method is used to rightclick element by using contextclick
 */
public void rightClick() {
	act.contextClick().perform();
}
/**
 * his method is used to rightclick element by using contextclick element
 * @param element
 */
public void rightClick(WebElement element) {
	act.contextClick(element).perform();
}
}